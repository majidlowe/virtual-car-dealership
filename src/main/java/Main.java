import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the dealership!");

        // creating instances of Car class
        Car volt = new Car("Chevy", "Volt",4000);
        Car porsche = new Car("Porsche", "911",200000);
        Car sienna = new Car("Toyota", "Sienna",30000);

        //Creating an empty list to add car instances to
        List<Car> carInventory = new ArrayList();

        //List of all cars sold
        List<Car> soldInventory = new ArrayList();

        // Add car instances to list
        carInventory.add(volt);
        carInventory.add(porsche);
        carInventory.add(sienna);

        System.out.println("Salesperson: Which car would you like to purchase?");

        //Displaying each car in car list
        for (int i = 0; i < carInventory.size(); i++) {
            carInventory.get(i).carInfo();
        }

        Scanner scanner = new Scanner(System.in);
        String carChoice = scanner.nextLine();
        System.out.println(carChoice);

        // check to make sure user input is an option from entire car list
        for (int i = 0; i < carInventory.size(); i++) {
            if(carChoice.equals(carInventory.get(i).getMake())) {
                System.out.println("Available");
            }
            else{
                System.out.println("Unavailable");
            }
        }


        System.out.println("Salesperson: Would you like to purchase this car? Please type Y or N");
        String buyOrNot = scanner.nextLine();

        //Prompt User to decide purchase
        for (int i = 0; i < carInventory.size(); i++) {

            if (buyOrNot.equals("Y")) {
                soldInventory.add(carInventory.get(i));
                carInventory.remove(carInventory.get(i));
            }
        }

        //Displaying each car in car list
        for (int i = 0; i < soldInventory.size(); i++) {
            System.out.println("Sold Recently: ");
            soldInventory.get(i).carInfo();
        }

        System.out.println("Sold Inventory: " + soldInventory);





    }
}