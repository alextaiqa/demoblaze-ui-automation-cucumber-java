package models;

public class PlaceOrderData {

    private final String fullName;
    private final String country;
    private final String city;
    private final String creditCardDigits;
    private final String month;
    private final String year;

    public PlaceOrderData(String fullName, String country, String city,
                          String creditCardDigits, String month, String year) {
        this.fullName = fullName;
        this.country = country;
        this.city = city;
        this.creditCardDigits = creditCardDigits;
        this.month = month;
        this.year = year;
    }

    public String getFullName() {
        return fullName;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getCreditCardDigits() {
        return creditCardDigits;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }
}
