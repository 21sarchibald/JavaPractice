import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class FinanceTracker {

    String menu = "1. Add new transaction\n2. Get account balance\n3. View all past transactions\n4. Quit program";
    Scanner scanner = new Scanner(System.in);
    private static Account account = new Account();

    public static void main(String[] args) {

        FinanceTracker tracker = new FinanceTracker();
        Scanner scanner = new Scanner(System.in);
        int userInput = 1;

        // account.getPreviousTransactions();
        // account.calculateBalance();

        do {

        System.out.println("This is the finance tracker");
        tracker.displayMenu();
        userInput = Integer.parseInt(scanner.nextLine());
        System.out.println("User selected: " + userInput); // Comment out later
        runUserProgram(userInput);
        }
        while (userInput != 4);
    }

    private void displayMenu() {
        System.out.println("Menu:");
        System.out.println(menu);
        System.out.print("Please select one of the menu options from above: ");
        
    }

    public String getStringUserInput() {
        String userInput = scanner.nextLine();
        return userInput;
    }

    public int getIntUserInput() {
        int userInput = scanner.nextInt();
        return userInput;
    }

    public float getFloatUserInput() {
        float userInput = scanner.nextFloat();
        return userInput;
    }

    private static void runUserProgram(int userInput) {
        Scanner scanner = new Scanner(System.in);
        switch (userInput) {
            case 1:
                System.out.println("Option 1");
                
                // Get user input for new transaction.
                System.out.print("Transaction date (yyyy-mm-dd): ");
                LocalDate date = LocalDate.parse(scanner.nextLine());

                System.out.print("Is the transaction a deposit or a withdrawal? (d/w): ");
                String transactionTypeInput = scanner.nextLine();

                System.out.print("Transaction amount: $");
                float amountInput = Float.parseFloat(scanner.nextLine());

                float calculatedAmount = calculateTransactionValue(transactionTypeInput, amountInput);

                System.out.print("Transaction description: ");
                String descriptionInput = scanner.nextLine();
                

                // Create new transaction instance with new data
                Transaction newTransaction = new Transaction(date, calculatedAmount, descriptionInput);

                
                // Add transaction to list and add/subtract amount from balance
                // Write transaction list to a file (rewrite at the end of every session)
                
                account.addNewTransaction(newTransaction);

                break;
            case 2:
                System.out.println("Option 2");
                account.calculateBalance();
                break;
            case 3:
                System.out.println("Option 3");
            default:
                System.out.println("Not a valid option.");
        }

    }
    public static float calculateTransactionValue(String transactionTypeInput, float amount) {
        if (transactionTypeInput.equalsIgnoreCase("d")) {
            return amount;
        }

        else if (transactionTypeInput.equalsIgnoreCase("w")) {
            return -amount;
        }

        else {
            return 0;
        }
    }

    
}
