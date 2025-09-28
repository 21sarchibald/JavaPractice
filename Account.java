import java.util.ArrayList;

public class Account {
    float balance;
    String name;
    ArrayList<Transaction> transactions = new ArrayList<>();

    public void displayBalance() {

    }

    // private void updateBalance(Transaction transaction) {
    //     float balance = getBalance();
    //     balance += transaction.getTransactionAmount();
    // }
}
