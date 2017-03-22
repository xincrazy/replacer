package highreactor.tool.replacer.config;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.Pair;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import static java.util.stream.Collectors.toMap;

@Slf4j
public class SupportedReplacerHelper {

    private static final Map<String, Pair<Class, Class>> supported;

    static {
        Properties prop = new Properties();
        try {
            prop.load(SupportedReplacerHelper.class.getClassLoader().getResourceAsStream("support.properties"));
        } catch (IOException e) {
            log.error("get support.properties occur exception", e);
            System.exit(1);
        }
        supported = prop.entrySet().stream().filter(item -> item.getKey().toString().indexOf('.') < 0).collect(toMap(
           item -> item.getKey().toString(),
           item -> Pair.of(getClass(item.getValue().toString()), getClass(prop.getProperty(item.getKey().toString() + ".processor"))))
        );
    }

    public static Class getItemClass(String type) {
        Pair<Class, Class> pair = getClassClassPair(type, "Not support item type [" + type + "]");
        return pair.getLeft();
    }

    public static Class getItemArrayClass(String type) {
        return getArrayClassTrick(getItemClass(type));
    }

    public static Class getProcessorClass(String type) {
        Pair<Class, Class> pair = getClassClassPair(type, "Not support processor type [" + type + "]");
        return pair.getRight();
    }

    @SneakyThrows
    private static Class getClass(String className) {
        return Class.forName(className);
    }

    private static Pair<Class, Class> getClassClassPair(String type, String message) {
        Pair<Class, Class> pair = supported.get(type);
        if (pair == null) throw new UnsupportedOperationException(message);
        return pair;
    }

    private static Class getArrayClassTrick(Class itemType) {
        return getClass("[L" + itemType.getName() + ";");
    }
}
