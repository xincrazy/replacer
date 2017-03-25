package highreactor.tool.replacer.processor;

import highreactor.tool.replacer.replacer.PropertyReplacer;
import lombok.SneakyThrows;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;

import java.net.URL;
import java.util.Arrays;

public class PropertiesWorker implements IReplacerWorker {

    private final FileBasedConfigurationBuilder<FileBasedConfiguration> builder;
    private final PropertyReplacer replacer;

    public PropertiesWorker(FileBasedConfigurationBuilder<FileBasedConfiguration> builder, PropertyReplacer replacer) {
        this.builder = builder;
        this.replacer = replacer;
    }

    @Override
    @SneakyThrows
    public void process() {
        Configuration configuration = builder.getConfiguration();
        Arrays.stream(replacer.getItems()).forEach(item -> configuration.setProperty(item.getKey(), item.getValue()));
    }

    @Override
    @SneakyThrows
    public void save(URL target) {
        builder.getFileHandler().save(target);
    }
}
