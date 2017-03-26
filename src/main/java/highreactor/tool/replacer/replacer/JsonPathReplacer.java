package highreactor.tool.replacer.replacer;

import highreactor.tool.replacer.items.JsonReplaceItem;
import lombok.Getter;

import static java.lang.Boolean.TRUE;

public class JsonPathReplacer extends BaseReplacer<JsonReplaceItem> {
    @Getter
    private Boolean pretty;

    @Override
    public BaseReplacer init() {
        this.pretty = (Boolean) config.getOrDefault("pretty", TRUE);
        return this;
    }
}
