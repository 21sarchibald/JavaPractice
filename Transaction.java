import java.time.LocalDate;

public class Transaction {
    private LocalDate date;
    private String transactionType;
    private float amount;
    private String description;


    public Transaction(LocalDate date, String transactionType, float amount, String description) {
        this.date = date;
        this.transactionType = transactionType;
        this.amount = amount;
        this.description = description;
    }

    public float getTransactionAmount(Transaction transaction) {
        return transaction.amount;
    }
}
