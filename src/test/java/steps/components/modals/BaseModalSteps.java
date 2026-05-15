package steps.components.modals;


import utils.TestData;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BaseModalSteps {

    // =======================
// GLOBAL VARIABLES
// =======================
    protected final TestData data;

    // =======================
// CONSTRUCTOR
// =======================
    public BaseModalSteps(String filePath) {
        this.data = new TestData(filePath);
    }

// =======================
// METHODS
// =======================

}
