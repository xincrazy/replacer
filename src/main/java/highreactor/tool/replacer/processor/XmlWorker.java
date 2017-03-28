package highreactor.tool.replacer.processor;


import highreactor.tool.replacer.replacer.XmlReplacer;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Document;

import java.io.File;
import java.net.URL;
import java.util.Arrays;

import static org.joox.JOOX.$;

@Slf4j
public class XmlWorker implements IReplacerWorker {

    private final Document document;

    private final XmlReplacer xmlReplacer;

    public XmlWorker(Document document, XmlReplacer xmlReplacer) {
        this.document = document;
        this.xmlReplacer = xmlReplacer;
    }

    @Override
    public void process() {
        Arrays.stream(xmlReplacer.getItems()).forEach(xmlReplaceItem ->
            $(document).xpath(xmlReplaceItem.getXPath()).text(xmlReplaceItem.getValue()));
    }

    @Override
    @SneakyThrows
    public void save(URL target) {
        $(document).write(new File(target.toURI()));
    }
}
