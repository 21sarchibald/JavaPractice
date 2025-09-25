public class Conditionals {
    public static void main(String[] args) {
        int i = 0;
        
        // Basic if statement
        if (i < 1) {

            System.out.println();
            System.out.println("Hello World");
            System.out.println();

        }

        // If else statement

        if (i < 0) {
            
            System.out.println();
            System.out.println("The value of i is negative");
            System.out.println();
        }

        else {
            System.out.println();
            System.out.println("The value of i is positive.");
            System.out.println();
        }

        // Switch statement

        switch (i) {

        case 0:
            System.out.println();
            System.out.println("The value of i is 0");
            System.out.println();
            break;
        
        case 1:
            System.out.println();
            System.out.println("The value of i is 1");
            System.out.println();
            break;

        case 2:
            System.out.println();
            System.out.println("The value of i is 2");
            System.out.println();
            break;
            

        }
    }
}
