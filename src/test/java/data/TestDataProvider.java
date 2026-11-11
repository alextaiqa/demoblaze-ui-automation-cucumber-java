package data;

import models.ContactModalData;
import models.login.LoginModalData;
import models.SignUpModalData;
import utils.YamlReader;

public class TestDataProvider {

    private final ContactModalData contactModalData;
    private final LoginModalData loginModalData;
    private final SignUpModalData signUpModalData;

    public TestDataProvider(YamlReader yamlReader) {
        signUpModalData = yamlReader.load("testdata/signUpModal.yaml", SignUpModalData.class);
        loginModalData = yamlReader.load("testdata/loginModal.yaml", LoginModalData.class);
        contactModalData = yamlReader.load("testdata/contactModal.yaml", ContactModalData.class);
    }

    public SignUpModalData getSignUpModalData() {
        return signUpModalData;
    }

    public LoginModalData getLoginModalData() {
        return loginModalData;
    }

    public ContactModalData getContactModalData() {
        return contactModalData;
    }
}
