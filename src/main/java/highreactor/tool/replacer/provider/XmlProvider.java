package highreactor.tool.replacer.provider;


import highreactor.tool.replacer.internal.SupportReplacer;
import highreactor.tool.replacer.processor.IReplacerWorker;
import highreactor.tool.replacer.processor.XmlWorker;
import highreactor.tool.replacer.replacer.BaseReplacer;
import highreactor.tool.replacer.replacer.XmlReplacer;
import lombok.SneakyThrows;
import org.joox.JOOX;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import java.io.File;
import java.lang.reflect.Type;
import java.net.URL;

public class XmlProvider implements IReplacerProvider {

    static {
        SupportReplacer.register("xml", new XmlProvider());
    }


    private XmlProvider() {
    }

    @Override
    public Type getReplacerType() {
        return XmlReplacer.class;
    }

    @Override
    @SneakyThrows
    public <T extends IReplacerWorker> T buildWorker(URL filePath, BaseReplacer replacer) {

        DocumentBuilder builder = JOOX.builder();

        Document document = builder.parse(new File(filePath.toURI()));

        return (T) new XmlWorker(document, (XmlReplacer) replacer);
    }
}
