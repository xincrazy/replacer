package highreactor.tool.replacer.config;

import lombok.Getter;

import java.util.List;

@Getter
public class ReplacerContext {
    private final List<Replacer> replacerList;

    public ReplacerContext(List<Replacer> replacerList) {
        this.replacerList = replacerList;
    }
}
