package highreactor.tool.replacer.internal;

import highreactor.tool.replacer.provider.IReplacerProvider;
import lombok.extern.slf4j.Slf4j;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static highreactor.tool.replacer.internal.LambdaExceptionUtil.rethrowConsumer;

@Slf4j
public class SupportReplacer {
    private static final Map<String, IReplacerProvider> ALL_REPLACER = new HashMap<>();

    static {
        try {
            Files.readAllLines(
                Paths.get(SupportReplacer.class.getClassLoader().getResource("replacer.support.list").toURI())
            ).forEach(rethrowConsumer(Class::forName));

        } catch (Exception e) {
            log.error("unable to load and init the replacer list", e);
        }
    }

    public static IReplacerProvider register(String type, IReplacerProvider provider) {
        ALL_REPLACER.put(type, provider);
        return provider;
    }

    public static IReplacerProvider getReplacer(String type) {
        IReplacerProvider replacer = ALL_REPLACER.get(type);
        if (replacer == null) throw new NoSuchElementException("Not found the replacer [" + type + "]");
        return replacer;
    }
}
