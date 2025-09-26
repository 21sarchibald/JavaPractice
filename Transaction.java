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
}
