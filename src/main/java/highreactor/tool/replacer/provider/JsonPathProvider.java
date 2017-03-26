package highreactor.tool.replacer.provider;

import com.jayway.jsonpath.JsonPath;
import highreactor.tool.replacer.internal.SupportReplacer;
import highreactor.tool.replacer.processor.IReplacerWorker;
import highreactor.tool.replacer.processor.JsonPathWorker;
import highreactor.tool.replacer.replacer.BaseReplacer;
import highreactor.tool.replacer.replacer.JsonPathReplacer;
import lombok.SneakyThrows;

import java.io.File;
import java.lang.reflect.Type;
import java.net.URL;

public class JsonPathProvider implements IReplacerProvider{
    static {
        SupportReplacer.register("json", new JsonPathProvider());
    }

    private JsonPathProvider() {}


    @Override
    public Type getReplacerType() {
        return JsonPathReplacer.class;
    }

    @Override
    @SneakyThrows
    public <T extends IReplacerWorker> T buildWorker(URL filePath, BaseReplacer replacer) {
        return (T)new JsonPathWorker(JsonPath.parse(new File(filePath.toURI())), (JsonPathReplacer) replacer);
    }

}
