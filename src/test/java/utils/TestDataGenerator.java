package utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestDataGenerator {

    //    GLOBAL VARIABLES
    private final Logger log;

    //    CONSTRUCTOR
    public TestDataGenerator() {
        log = LoggerFactory.getLogger(this.getClass());
    }

    //    METHODS
    public String generateUsername() {
        String username = "AutoUser" + generateTenRandomLetters();
        log.info("Generated a username: {}", username);
        return username;
    }

    public String generatePassword() {
        String specialCharacters = "!@#$%^&*";

        String password = generateTenRandomLetters();
        password += System.currentTimeMillis();
        password += RandomStringUtils.insecure().next(1, specialCharacters.toCharArray());

        log.info("Generated a password: {}", password);
        return password;
    }

    public String generateEmail() {
        String email = "AutoUser" + generateTenRandomLetters() + "@example.com";
        log.info("Generated an email {}", email);
        return email;
    }


    //HELPERS
    private String generateTenRandomLetters() {
        return RandomStringUtils.insecure().nextAlphabetic(10);
    }
}
