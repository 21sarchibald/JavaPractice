import java.time.LocalDate;

public class Transaction {
    private LocalDate date;
    private int transactionType;
    private float amount;
    private String description;


    public Transaction(LocalDate date, int transactionType, float amount, String description) {
        this.date = date;
        this.transactionType = transactionType;
        this.amount = amount;
        this.description = description;
    }

    public float getTransactionValue(Transaction transaction) {
        float transactionOperationValue = transaction.transactionType * transaction.amount;
    
        return transactionOperationValue;
    }

    public String toString() {
        return date.toString() + "," + transactionType + "," + amount + "," + description;
    }
}
