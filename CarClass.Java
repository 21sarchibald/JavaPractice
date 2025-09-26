public class CarClass {

    String color:
    int year;
    String make;
    String model;

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