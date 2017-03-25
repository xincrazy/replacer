package highreactor.tool.replacer.processor;

import java.net.URL;

public interface IReplacerWorker {
    void process();

    void save(URL target);
}
