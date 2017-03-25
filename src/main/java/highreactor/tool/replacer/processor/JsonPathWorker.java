package highreactor.tool.replacer.processor;

import com.jayway.jsonpath.DocumentContext;
import highreactor.tool.replacer.replacer.JsonPathReplacer;

import java.net.URL;
import java.util.Arrays;

public class JsonPathWorker implements IReplacerWorker {

    private final DocumentContext context;
    private final JsonPathReplacer replacer;

    public JsonPathWorker(DocumentContext context, JsonPathReplacer replacer) {
        this.context = context;
        this.replacer = replacer;
    }

    public void process() {
        Arrays.stream(replacer.getItems()).forEach(item -> context.set(item.getJsonPath(), item.getValue()));
    }

    @Override
    public void save(URL target) {

    }
}
