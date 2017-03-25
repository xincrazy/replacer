package highreactor.tool.replacer.config.gson;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import highreactor.tool.replacer.replacer.BaseReplacer;

import java.lang.reflect.Type;
import java.util.Map;

import static highreactor.tool.replacer.internal.SupportReplacer.getReplacer;
import static java.util.stream.Collectors.toMap;

public class ReplacerContextDeserializer implements JsonDeserializer<Map<String, BaseReplacer>> {
    public Map<String, BaseReplacer> deserialize(JsonElement element, Type currentType, JsonDeserializationContext context) throws JsonParseException {
        return element.getAsJsonObject().entrySet().stream().collect(
            toMap(Map.Entry::getKey,
                it -> ((BaseReplacer)context.deserialize(it.getValue(), getReplacer(it.getKey()).getReplacerType())).init()
            )
        );
    }
}
