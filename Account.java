import java.io.FileWriter;
import java.util.ArrayList;
import java.io.IOException;
import java.io.*; // imports everything from this library
import java.nio.file.*; // imports everything from this library
import java.util.*; // imports everything from this library
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Go through and clean out imports to make them simpler



public class Account {
    float balance;
    String name;
    ArrayList<Transaction> transactions = new ArrayList<>();

    public void displayBalance() {

    }

    public void calculateBalance() {
        balance = 0;
        transactions = getPreviousTransactions();

        // Get transaction amount from each transaction in transactions list.
        for (Transaction transaction : transactions) {
            balance += transaction.getAmount();
        }
        
        // Display account balance to user.
        System.out.println("Current account balance: $ " + balance);
    }

    public void addNewTransaction(Transaction transaction) {
        transactions = getPreviousTransactions();
        transactions.add(transaction);
        writeTransactionsToFile("account.csv");
        System.out.println("Transaction succesfully added.");
    }

    public void writeTransactionsToFile(String fileName) {
       
        try (FileWriter fileWriter = new FileWriter(fileName)) {

        // Write transaction to file.
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

        // Initiate list to store previous transaction strings
        ArrayList<Transaction> previousTransactions = new ArrayList<>();

        try {
        List<String> fileLines = Files.readAllLines(Paths.get("account.csv"));
        
        for (String line : fileLines) {
            String[] attributes = line.split(",");

            // Create new instance of a transaction with attributes from the csv file.
            Transaction newTransaction = new Transaction(LocalDate.parse(attributes[0]), Float.parseFloat(attributes[1]), attributes[2]);
            
            previousTransactions.add(newTransaction);
        }
    }
        catch (IOException e) {
            System.out.println("Error loading file.");
        }
       
        return previousTransactions;
    }

    public void displayPreviousTransactions() {
        System.out.println("Previous Transactions:");
        System.out.println();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        transactions = getPreviousTransactions();
        for (Transaction transaction : transactions) {

            System.out.println("Date: " + transaction.getDate().format(formatter));
            System.out.println("Amount: $ " + transaction.getAmount());
            System.out.println("Description: " + transaction.getDescription());
            System.out.println();
        }
    }
}
