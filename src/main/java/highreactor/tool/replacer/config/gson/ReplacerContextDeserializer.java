package highreactor.tool.replacer.config.gson;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import highreactor.tool.replacer.config.Replacer;
import highreactor.tool.replacer.config.ReplacerContext;

import java.lang.reflect.Type;

import static highreactor.tool.replacer.config.SupportedReplacerHelper.getItemArrayClass;
import static java.util.stream.Collectors.toList;

public class ReplacerContextDeserializer implements JsonDeserializer<ReplacerContext> {
    public ReplacerContext deserialize(JsonElement element, Type currentType, JsonDeserializationContext context) throws JsonParseException {
        return new ReplacerContext(element.getAsJsonObject().entrySet().stream().map(entry -> {
            String type = entry.getKey();
            Class item = getItemArrayClass(type);
            return new Replacer(type, context.deserialize(entry.getValue(), item));
        }).collect(toList()));
    }
}
