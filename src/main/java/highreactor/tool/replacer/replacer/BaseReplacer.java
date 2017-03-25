package highreactor.tool.replacer.replacer;

import lombok.Getter;

import java.util.Map;

public abstract class BaseReplacer<T> {
    protected Map<String, Object> config;

    @Getter
    protected T[] items;

    public abstract BaseReplacer init();
}
