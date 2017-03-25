package highreactor.tool.replacer.items;

import com.jayway.jsonpath.JsonPath;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JsonReplaceItem {
    private JsonPath jsonPath;
    private Object value;
}
