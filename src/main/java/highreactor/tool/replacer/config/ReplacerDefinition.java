package highreactor.tool.replacer.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReplacerDefinition {
    private String filePath;
    private ReplacerContext replacer;
}
