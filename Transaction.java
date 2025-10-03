import java.time.LocalDate;

public class Transaction {
    private LocalDate date;
    private float amount;
    private String description;


    public Transaction(LocalDate date, float amount, String description) {
        this.date = date;
        this.amount = amount;
        this.description = description;
    }

    public String toString() {
        return date.toString() + "," + amount + "," + description;
    }

    public LocalDate getDate() {
        return date;
    }

    public float getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

}
