import java.util.Scanner;
import java.time.LocalDate;

public class FinanceTracker {

    String menu = "1. Add new transaction\n2. Get account balance\n3. View all past transactions\n4. Quit program";
    Scanner scanner = new Scanner(System.in);
    private static Account account = new Account();

    public static void main(String[] args) {

        FinanceTracker tracker = new FinanceTracker();
        Scanner scanner = new Scanner(System.in);
        int userInput = 1;

        System.out.println();
        System.out.println("Welcome to the Finance Tracker");

        do {
        
        System.out.println();
        tracker.displayMenu();
        if (scanner.hasNextInt()) {
            userInput = scanner.nextInt();

        } else {
            System.out.println("Not a valid option. Please enter an integer (1-4).");
        }
        System.out.println();
        tracker.runUserProgram(userInput);
        }
        while (userInput != 4);
    }

    private void displayMenu() {
        System.out.println("Menu:");
        System.out.println();
        System.out.println(menu);
        System.out.println();
        System.out.print("Please select one of the menu options from above: ");
        
    }

    public String getStringUserInput() {
        String userInput = scanner.nextLine();
        return userInput;
    }

    public LocalDate getDateUserInput() {
        LocalDate userInput = LocalDate.parse(scanner.nextLine());
        return userInput;
    }

    private void runUserProgram(int userInput) {
        
        switch (userInput) {
            case 1:
                
                // Get user input for new transaction.
                System.out.print("Transaction date (yyyy-mm-dd): ");
                LocalDate date = getDateUserInput();

                System.out.print("Is the transaction a deposit or a withdrawal? (d/w): ");
                String transactionTypeInput = getStringUserInput();

                System.out.print("Transaction amount: $");
                Float amountInput = Float.parseFloat(scanner.nextLine());

                float calculatedAmount = calculateTransactionValue(transactionTypeInput, amountInput);

                System.out.print("Transaction description: ");
                String descriptionInput = getStringUserInput();
                

                // Create new transaction instance with new data
                Transaction newTransaction = new Transaction(date, calculatedAmount, descriptionInput);
                
                // Add new transaction to list of transactions using Account method
                account.addNewTransaction(newTransaction);

                break;

            case 2:
                account.calculateBalance();
                break;

            case 3:
                account.displayPreviousTransactions();
                break;

            case 4:
                System.out.print("Exited program.");
                break;
                
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
