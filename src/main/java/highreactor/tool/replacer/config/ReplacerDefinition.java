package highreactor.tool.replacer.config;

import highreactor.tool.replacer.replacer.BaseReplacer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReplacerDefinition {
    private String filePath;
    private Map<String, BaseReplacer> replacer;
}
