package highreactor.tool.replacer.config;

import org.junit.Test;

import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ConfigParserTest {

    @Test
    public void check_parse_replacer_json() throws UnsupportedEncodingException {
        ReplacerDefinition[] definitions = ConfigParser.parse(
            new InputStreamReader(
                ConfigParserTest.class.getClassLoader().getResourceAsStream("replacer.json")
                , "UTF-8")
        );

        assertThat(definitions.length, is(2));

        assertEquals("workers.json", definitions[0].getFilePath());

        assertEquals("json", definitions[0].getReplacer().getReplacerList().get(0).getType());

    }
}
