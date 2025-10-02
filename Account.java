import java.io.FileWriter;
import java.util.ArrayList;
import java.io.IOException;
import java.io.*; // imports everything from this library
import java.nio.file.*; // imports everything from this library
import java.util.*; // imports everything from this library
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

// Go through and clean out imports to make them simpler



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
        fileWriter.close();
        }
        catch (IOException e) {
            System.out.print("Could not add transactions to" + fileName);
        }
        
    }

    public ArrayList<Transaction> getPreviousTransactions() {
        // Read through file using Files.ReadAllLines
        try {
        List<String> fileLines = Files.readAllLines(Paths.get("account.csv"));
        
        for (String line : fileLines) {
            String[] attributes = line.split(",");
            System.out.println(attributes[0]);
            System.out.println(attributes[1]);
            System.out.println(attributes[2]);
            
            
            // Transaction newTransaction = new Transaction()
        }
    }
        catch (IOException e) {
            System.out.println("Error loading file.");
        }

        // For each line, create a new instance
        // Go through and split it on the comma
        // Use each value to fill the attributes in the new instance
       
        
        return transactions;
        // fix function
    }
}
