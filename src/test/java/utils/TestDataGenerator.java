package utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class TestDataGenerator {

    //    GLOBAL VARIABLES
    private final Logger log;

    //    CONSTRUCTOR
    public TestDataGenerator() {
        log = LoggerFactory.getLogger(this.getClass());
    }

    //    METHODS
    public String generateUsername() {
        String username = "AutoUser" + RandomStringUtils.insecure().nextAlphabetic(10);
        log.info("Generated a username: {}", username);
        return username;
    }

    public String generatePassword(String generatedUsername, boolean hasNumbers, boolean hasSpecialCharacters) {
        String specialCharacters = "!@#$%^&*";

        String password = generatedUsername == null ? generateUsername() : generatedUsername;

        if (hasNumbers) {
            password += System.currentTimeMillis();
        }

        if (hasSpecialCharacters) {
            password += RandomStringUtils.insecure().next(1, specialCharacters.toCharArray());
        }

        log.info("Generated a password: {}", password);
        return password;
    }

    //generate email??
}
