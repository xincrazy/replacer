package highreactor.tool.replacer.config.gson;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.Option;
import com.jayway.jsonpath.spi.json.GsonJsonProvider;
import com.jayway.jsonpath.spi.json.JsonProvider;
import com.jayway.jsonpath.spi.mapper.GsonMappingProvider;
import com.jayway.jsonpath.spi.mapper.MappingProvider;

import java.util.EnumSet;
import java.util.Set;

public class GsonConfiguration implements Configuration.Defaults {
    private final JsonProvider jsonProvider = new GsonJsonProvider();
    private final MappingProvider mappingProvider = new GsonMappingProvider();
    @Override
    public JsonProvider jsonProvider() {
        return jsonProvider;
    }

    @Override
    public Set<Option> options() {
        return EnumSet.noneOf(Option.class);
    }

    @Override
    public MappingProvider mappingProvider() {
        return mappingProvider;
    }
}
