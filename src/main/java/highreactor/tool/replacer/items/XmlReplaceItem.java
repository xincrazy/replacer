package highreactor.tool.replacer.items;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class XmlReplaceItem {
    private String xPath;
    private String value;
}
