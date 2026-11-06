package utils;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;

public class YamlReader {

    public <T> T load(String filepath, Class<T> modelClass) {
        Yaml yaml = new Yaml();

        try (InputStream in = YamlReader.class.getClassLoader().getResourceAsStream(filepath)) {

            if (in == null) {
                throw new RuntimeException("Yaml file not found: " + filepath);
            }

            return yaml.loadAs(in, modelClass);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load YAML: " + filepath, e);
        }
    }
}
