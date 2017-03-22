package highreactor.tool.replacer.items;

import com.jayway.jsonpath.JsonPath;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JsonReplaceItem extends IReplaceItem {
    private JsonPath jsonPath;
    private Object value;
}
