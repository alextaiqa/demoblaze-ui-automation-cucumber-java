package models;

public class PurchaseData {

    private final String message;
    private final int total;
    private final String cardData;
    private final String name;

    public PurchaseData(String message, int total, String cardData, String name) {
        this.message = message;
        this.total = total;
        this.cardData = cardData;
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public int getTotal() {
        return total;
    }

    public String getCardData() {
        return cardData;
    }

    public String getName() {
        return name;
    }
}
