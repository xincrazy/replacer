package highreactor.tool.replacer.items;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertiesReplaceItem extends IReplaceItem {
    private String key;
    private String value;
}
