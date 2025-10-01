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

    // public float getDateUserInput() {
    //     String userInput = scanner.nextLine();

        // return userInput;
    // }

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
                int transactionType = 0;

                if (transactionTypeInput == "d") {
                    transactionType = 1;
                }

                else if (transactionTypeInput == "w") {
                    transactionType = -1;
                }
                
                System.out.print("Transaction amount: $");
                float amount = Float.parseFloat(scanner.nextLine());

                System.out.print("Transaction description: ");
                String description = scanner.nextLine();
                

                // Create new transaction instance with new data
                Transaction newTransaction = new Transaction(date, transactionType, amount, description);

                
                // Add transaction to list and add/subtract amount from balance
                
                account.addNewTransaction(newTransaction);
                System.out.println(newTransaction);
                System.out.println(account.transactions);
                System.out.println(newTransaction.toString());

                break;
            case 2:
                System.out.println("Option 2");
                break;
            case 3:
                System.out.println("Option 3");
            default:
                System.out.println("Not a valid option.");
        }

    }
    
}
