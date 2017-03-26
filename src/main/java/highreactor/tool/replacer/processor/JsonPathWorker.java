package highreactor.tool.replacer.processor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jayway.jsonpath.DocumentContext;
import highreactor.tool.replacer.replacer.JsonPathReplacer;
import lombok.SneakyThrows;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class JsonPathWorker implements IReplacerWorker {

    private final DocumentContext context;
    private final JsonPathReplacer replacer;

    public JsonPathWorker(DocumentContext context, JsonPathReplacer replacer) {
        this.context = context;
        this.replacer = replacer;
    }

    public void process() {
        Arrays.stream(replacer.getItems()).forEach(item -> {
            if (item.getValue() instanceof Double) {
                Double value = (Double) item.getValue();
                if ((value == Math.floor(value)) && !Double.isInfinite(value)) {
                    context.set(item.getJsonPath(), value.longValue());
                }
            } else {
                context.set(item.getJsonPath(), item.getValue());
            }
        });
    }

    @Override
    @SneakyThrows
    public void save(URL target) {
        //TODO remove this
        GsonBuilder gsonBuilder = new GsonBuilder();
        if (replacer.getPretty()) {
            gsonBuilder.setPrettyPrinting();
        }
        Gson gson = gsonBuilder.create();
        Files.write(Paths.get(target.toURI()), gson.toJson(context.json()).getBytes());
    }
}
