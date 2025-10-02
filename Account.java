import java.io.FileWriter;
import java.util.ArrayList;
import java.io.IOException;

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

    // For balance storage, I think we are going to just recalculate the balance
    // from all transactions every time we load the program/add a new transaction

    public void addNewTransaction(Transaction transaction) {
        transactions.add(transaction);
        writeTransactionsToFile("account.csv");
        System.out.println("Transaction succesfully added.");
    }

    public void writeTransactionsToFile(String fileName) {
       try (FileWriter fileWriter = new FileWriter(fileName)) {

        for (Transaction transaction : this.transactions) {
            fileWriter.write(transaction.toString() + "\n");
        
        }
        System.out.println("File written");
        fileWriter.close();
        }
        catch (IOException e) {
            System.out.print("Could not add transactions to" + fileName);
        }
        
    }
}
