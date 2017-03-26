package highreactor.tool.replacer.provider;

import highreactor.tool.replacer.internal.SupportReplacer;
import highreactor.tool.replacer.processor.IReplacerWorker;
import highreactor.tool.replacer.processor.PropertiesWorker;
import highreactor.tool.replacer.replacer.BaseReplacer;
import highreactor.tool.replacer.replacer.PropertyReplacer;
import lombok.SneakyThrows;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;

import java.io.File;
import java.lang.reflect.Type;
import java.net.URL;

public class PropertyProvider implements IReplacerProvider{
    static {
        SupportReplacer.register("property", new PropertyProvider());
    }

    private PropertyProvider() {}


    @Override
    public Type getReplacerType() {
        return PropertyReplacer.class;
    }

    @Override
    @SneakyThrows
    public <T extends IReplacerWorker> T buildWorker(URL filePath, BaseReplacer replacer) {
        FileBasedConfigurationBuilder<FileBasedConfiguration> builder = new FileBasedConfigurationBuilder<FileBasedConfiguration>(
            PropertiesConfiguration.class
        ).configure(new Parameters().properties().setFile(new File(filePath.toURI())));
        return (T) new PropertiesWorker(builder, (PropertyReplacer) replacer);
    }
}
