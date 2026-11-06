package data;

import models.login.LoginModalData;
import models.SignUpModalData;
import utils.YamlReader;

public class TestDataProvider {

    private final SignUpModalData signUpModalData;
    private final LoginModalData loginModalData;

    public TestDataProvider(YamlReader yamlReader) {
        signUpModalData = yamlReader.load("testdata/signUpModal.yaml", SignUpModalData.class);
        loginModalData = yamlReader.load("testdata/loginModal.yaml", LoginModalData.class);
    }

    public SignUpModalData getSignUpModalData() {
        return signUpModalData;
    }

    public LoginModalData getLoginModalData() {
        return loginModalData;
    }
}
