package config;

import utils.TestData;

import java.time.Duration;

public class Config {
    private final TestData data;

    public Config() {
        this.data = new TestData("config.yaml");
    }

    public Duration getRegularWait() {
        return Duration.ofSeconds(Integer.parseInt(data.get("explicit.regular.wait")));
    }

    public Duration getAlertWait() {
        return Duration.ofSeconds(Integer.parseInt(data.get("explicit.alert.wait")));
    }
}
