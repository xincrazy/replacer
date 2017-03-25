package highreactor.tool.replacer.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.reflect.TypeToken;
import com.jayway.jsonpath.JsonPath;
import highreactor.tool.replacer.config.gson.ReplacerContextDeserializer;
import highreactor.tool.replacer.replacer.BaseReplacer;

import java.io.Reader;
import java.util.Map;

public class ConfigParser {
    private static final Gson gson = new GsonBuilder()
        .registerTypeAdapter(new TypeToken<Map<String, BaseReplacer>>(){}.getType(), new ReplacerContextDeserializer())
        .registerTypeAdapter(JsonPath.class, (JsonDeserializer<JsonPath>) (json, typeOfT, context) -> JsonPath.compile(json.getAsString()))
        .create();

    public static ReplacerDefinition[] parse(Reader reader) {
        return gson.fromJson(reader, ReplacerDefinition[].class);
    }
}
