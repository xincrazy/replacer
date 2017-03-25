package highreactor.tool.replacer.replacer;

import highreactor.tool.replacer.items.JsonReplaceItem;

import static java.lang.Boolean.TRUE;

public class JsonPathReplacer extends BaseReplacer<JsonReplaceItem> {
    private Boolean pretty;

    @Override
    public BaseReplacer init() {
        this.pretty = (Boolean) config.getOrDefault("pretty", TRUE);
        return this;
    }
}
