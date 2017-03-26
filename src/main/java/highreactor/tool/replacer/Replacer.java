package highreactor.tool.replacer;

import highreactor.tool.replacer.config.ConfigParser;
import highreactor.tool.replacer.config.ReplacerDefinition;
import highreactor.tool.replacer.internal.SupportReplacer;
import highreactor.tool.replacer.processor.IReplacerWorker;
import highreactor.tool.replacer.provider.IReplacerProvider;
import highreactor.tool.replacer.replacer.BaseReplacer;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.Map;

@Slf4j
public class Replacer {
    public static void main(String[] args) {
        // TODO jcommander
        if (args == null || args.length == 0) {
            log.error("Not found the replacer.json");
            return;
        }
        String replacerPath = args[0];

        File replacerFile = new File(replacerPath);

        if (!replacerFile.exists() || replacerFile.isDirectory()) {
            log.error("File not found or is directory");
            return;
        }

        try {
            ReplacerDefinition[] definitions = ConfigParser.parse(new InputStreamReader(new FileInputStream(replacerFile), "UTF-8"));

            Arrays.stream(definitions).forEach(it -> {
                //TODO validator
                String savePath = it.getSavePath() == null ? it.getFilePath() : it.getSavePath();

                internalProcess(it.getFilePath(), savePath, it.getReplacer());

            });

        } catch (Exception e) {
            log.error("TODO remove this shit", e);
        }

    }

    @SneakyThrows
    private static void internalProcess(String filePath, String savePath, Map<String, BaseReplacer> replacer) {
        URL file = new File(filePath).toURI().toURL();
        URL save = new File(savePath).toURI().toURL();
        replacer.entrySet().forEach(it -> {
            IReplacerProvider provider = SupportReplacer.getReplacer(it.getKey());
            IReplacerWorker worker = provider.buildWorker(file, it.getValue());
            worker.process();
            worker.save(save);
        });

    }
}
