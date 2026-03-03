package steps;

import utils.TestData;

public class BaseSteps {

    protected final TestData data;

    public BaseSteps(String filePath) {
        this.data = new TestData(filePath);
    }
}
