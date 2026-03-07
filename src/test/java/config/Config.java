package config;

import utils.TestData;

import java.time.Duration;

public class Config {
    private final TestData data;

    public Config() {
        this.data = new TestData("config/config.yaml");
    }

    public String getBrowser() {
        return data.get("browserChrome");
    }

    public boolean isHeadless() { //"true" is used on a ci server
        return Boolean.parseBoolean(data.get("headless"));
    }

    public Duration getRegularWait() {
        return Duration.ofSeconds(Integer.parseInt(data.get("explicit.regular.wait")));
    }

    public Duration getAlertWait() {
        return Duration.ofSeconds(Integer.parseInt(data.get("explicit.alert.wait")));
    }
}
