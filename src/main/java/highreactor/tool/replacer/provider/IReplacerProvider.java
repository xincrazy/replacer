package highreactor.tool.replacer.provider;

import highreactor.tool.replacer.replacer.BaseReplacer;

import java.lang.reflect.Type;
import java.net.URL;

public interface IReplacerProvider {

    Type getReplacerType();

    <T> T buildProcessor(URL filePath, BaseReplacer replacer);
}
