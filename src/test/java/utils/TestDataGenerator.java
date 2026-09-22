package utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestDataGenerator {

    //    GLOBAL VARIABLES
    private final Logger log;
    private final String standardNameStart = "AutoUser";
    private final Map<String, List<String>> locations = Map.of(
            "The U.S.", List.of("San Francisco", "New York", "Miami"),
            "Canada", List.of("Toronto", "Montreal", "Vancouver"),
            "England", List.of("London", "Manchester", "Birmingham"),
            "Japan", List.of("Tokyo", "Yokohama", "Osaka"),
            "China", List.of("Shanghai", "Beijing", "Chongqing"),
            "Sweden", List.of("Stockholm", "Gothenburg", "Uppsala"),
            "Poland", List.of("Warsaw", "Kraków", "Lublin"),
            "Germany", List.of("Berlin", "Hamburg", "Munich"),
            "France", List.of("Paris", "Marseille", "Lyon"),
            "Switzerland", List.of("Zurich", "Geneva", "Basel")
    );

    //    CONSTRUCTOR
    public TestDataGenerator() {
        log = LoggerFactory.getLogger(this.getClass());
    }

    //    METHODS
    public String generateUsername() {
        String username = standardNameStart + generateTenRandomLetters();
        log.info("Generated a username: {}", username);
        return username;
    }

    public String generateFullName() {
        String fullName = standardNameStart + generateRandomLetters(5);
        log.info("Generated a full name: {}", fullName);
        return fullName;
    }

    public String generateCountry() {
        List<String> countries = new ArrayList<>(locations.keySet());
        String selectedCountry = countries.get(generateRandomIndex(countries.size()));
        log.info("Generated a random country: {}", selectedCountry);
        return selectedCountry;
    }

    public String generateCity(String country) {
        List<String> countryCities = locations.get(country);
        String selectedCity = countryCities.get(generateRandomIndex(countryCities.size())); //selects a city from cities
        log.info("Generated a city: {}", selectedCity);
        return selectedCity;
    }

    public String generatePassword() {
        String specialCharacters = "!@#$%^&*";

        String password = generateTenRandomLetters();
        password += System.currentTimeMillis();
        password += RandomStringUtils.insecure().next(1, specialCharacters.toCharArray());

        log.info("Generated a password: {}", password);
        return password;
    }

    public String generateMonth() {
        int randomMonthNum = generateRandomIndex(12) + 1;
        return addZeroToMonth(randomMonthNum);
    }

    public String generateEmail() {
        String email = standardNameStart + generateTenRandomLetters() + "@example.com";
        log.info("Generated an email {}", email);
        return email;
    }


    //HELPERS
    private String generateTenRandomLetters() {
        return generateRandomLetters(10);
    }

    private String generateRandomLetters(int count) {
        return RandomStringUtils.insecure().nextAlphabetic(count);
    }

    private int generateRandomIndex(int size) { //from 0 to max entered -1
        return (int) (Math.random() * size);
    }

    private String addZeroToMonth(int monthNumber) {
        return String.format("%02d", monthNumber);
    }
}
