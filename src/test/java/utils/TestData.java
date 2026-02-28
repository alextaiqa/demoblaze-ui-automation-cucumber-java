package utils;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

public class TestData {

    private final Map<String, Object> data;

    public TestData(String fileName) {
        Yaml yaml = new Yaml();
        try (InputStream in = TestData.class.getClassLoader().getResourceAsStream("testData/" + fileName)) {
            data = yaml.load(in);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load YAML: " + fileName, e);
        }
    }

    public String get(String key) {
        return (String) data.get(key);
    }
}