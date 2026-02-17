package config;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties props;

    private static Properties getProperties(){ // what is all of this????
        try {
            if (props == null){
                props = new Properties();
                FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
                props.load(fis);
            }
        } catch (Exception e) {
            e.printStackTrace(); // what is this???
        }
        return props;
    }
}
