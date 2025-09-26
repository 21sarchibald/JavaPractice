public class CarClass {

    String color:
    int year;
    String make;
    String model;


    // This is a constructor. It automatically runs when you call use the keyword new Car and
    // sets the class attributes equal to the arguments you pass into the constructor.
    
    public Car(String carColor, int carYear, String carMake, String carModel) {
        color = carColor;
        year = carYear;
        make = carMake;
        model = carModel;
    }

    // Methods
    public void startEngine() {
        System.out.println("Engine started for the " + carYear + " " + carColor + " " + carMake " " + carMake + ".");
    }
}