package utils;

import models.PlaceOrderData;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestDataGenerator {

    //    GLOBAL VARIABLES
    private final Logger log;
    private static final String STANDARD_NAME_START = "AutoUser";
    private static final Map<String, List<String>> LOCATIONS = Map.of(
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
        String username = STANDARD_NAME_START + generateTenRandomLetters();
        log.info("Generated a username: {}", username);
        return username;
    }

    public String generateFullName() {
        String fullName = STANDARD_NAME_START + generateRandomLetters(5);
        log.info("Generated a full name: {}", fullName);
        return fullName;
    }

    public String generateCountry() {
        List<String> countries = new ArrayList<>(LOCATIONS.keySet());
        String selectedCountry = countries.get(generateRandomIndex(countries.size()));
        log.info("Generated a random country: {}", selectedCountry);
        return selectedCountry;
    }

    public String generateCity(String country) {
        List<String> countryCities = LOCATIONS.get(country);
        if (countryCities == null) {
            throw new IllegalArgumentException("Unsupported country: " + country);
        }
        String selectedCity = countryCities.get(generateRandomIndex(countryCities.size())); //selects a city from cities
        log.info("Generated a city: {}", selectedCity);
        return selectedCity;
    }

    public String generatePassword() {
        String specialCharacters = "!@#$%^&*";

        String password = generateTenRandomLetters();
        password += System.currentTimeMillis();
        password += RandomStringUtils.insecure().next(1, specialCharacters.toCharArray());

        log.info("Generated a random password");
        return password;
    }

    public String generateCreditCardDigits() {
        String generatedDigits = generateStringOfNumbers(16);
        log.info("Generated credit card digits: {}", generatedDigits);
        return generatedDigits;
    }

    public String generateMonth() {
        int randomMonthNum = generateRandomNumberWithoutZero(12);
        String month = addZeroToMonth(randomMonthNum);
        log.info("Generated a month: {}", month);
        return month;
    }

    public String generateYear() {
        String generatedYear = Integer.toString(
                LocalDate.now().getYear() + generateRandomNumberWithoutZero(4));
        log.info("Generated a year: {}", generatedYear);
        return generatedYear;
    }

    public String generateEmail() {
        String email = STANDARD_NAME_START + generateTenRandomLetters() + "@example.com";
        log.info("Generated an email {}", email);
        return email;
    }

    public PlaceOrderData generatePlaceOrderData() {
        String country = generateCountry();

        return new PlaceOrderData(
                generateFullName(),
                country,
                generateCity(country),
                generateCreditCardDigits(),
                generateMonth(),
                generateYear()
        );
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

    private int generateRandomNumber(int maxNumber) {
        return generateRandomIndex(maxNumber + 1); // from 0 to max entered
    }

    private int generateRandomNumberWithoutZero(int maxNumber) {
        return generateRandomIndex(maxNumber) + 1;
    }

    private String addZeroToMonth(int monthNumber) {
        return String.format("%02d", monthNumber);
    }

    private String generateStringOfNumbers(int size) {
        StringBuilder numbers = new StringBuilder();
        for (int i = 1; i <= size; i++) {
            numbers.append(generateRandomNumber(9));
        }
        return numbers.toString();
    }
}
