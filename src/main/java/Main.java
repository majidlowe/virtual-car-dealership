import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the dealership!");

        // creating instances of Car class
        Car volt = new Car("Volt", "Chevy",4000);
        Car porsche = new Car("911", "Porsche",200000);
        Car sienna = new Car("Sienna", "Toyota",30000);

        //Creating an empty list to add car instances to
        List<Car> carInventory = new ArrayList();

        // Add car instances to list
        carInventory.add(volt);
        carInventory.add(porsche);
        carInventory.add(sienna);

        System.out.println("Which car would you like to purchase?");

        //Displaying each car in car list
        for (int i = 0; i < carInventory.size(); i++) {
            carInventory.get(i).carInfo();
        }

        Scanner scanner = new Scanner(System.in);
        String carChoice = scanner.nextLine();
        System.out.println(carChoice);

        // check to make sure user input is an option from entire car list





    }
}