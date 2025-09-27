import java.util.Scanner;

public class FinanceTracker {

    String menu = "1. Add new transaction\n2. Get account balance\n3. View all past transactions\n4. Quit program";
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        FinanceTracker tracker = new FinanceTracker();
        Scanner scanner = new Scanner(System.in);

        System.out.println("This is the finance tracker");
        tracker.displayMenu();
        String userInput = scanner.nextLine();
        System.out.println("User selected: " + userInput);
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
    //     float userInput = scanner.nextFloat();
    //     return userInput;
    // }
    
}
