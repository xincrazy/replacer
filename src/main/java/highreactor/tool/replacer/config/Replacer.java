package highreactor.tool.replacer.config;

import highreactor.tool.replacer.items.IReplaceItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Replacer {
    private String type;
    private IReplaceItem[] items;
}
