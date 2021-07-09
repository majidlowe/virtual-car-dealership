import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Dealership {
    private List<Car> availableCars;
    private List<Car> soldInventory;

    public Dealership() {
        this.availableCars = new ArrayList();
        this.soldInventory = new ArrayList();
    }

    private void stockInventory() {
        Car volt = new Car("Chevy", "Volt", 4000);
        Car porsche = new Car("Porsche", "911", 200000);
        Car sienna = new Car("Toyota", "Sienna", 30000);

        this.availableCars.add(volt);
        this.availableCars.add(porsche);
        this.availableCars.add(sienna);
    }

    public void runSalesAppointments() {
        stockInventory();

        System.out.println("Salesperson: Welcome to the dealership!  \n\nWhich car would you like to purchase?");

        showAvailableCars();

        Scanner scanner = new Scanner(System.in);
        String carChoice = scanner.nextLine();
        System.out.println("Great!  You selected " + carChoice);

        int carChoiceIndex = getIndexOfSelectedCar(carChoice);


        System.out.println("Salesperson: Great! Would you like to purchase the " + carChoice + " ? Please type Y or N");
        String buyOrNot = scanner.nextLine();

        if (buyOrNot.equals("Y")) {
            this.soldInventory.add(this.availableCars.get(carChoiceIndex));
            this.availableCars.remove(this.availableCars.get(carChoiceIndex));
        } else {
            System.out.println("Which car would you like to purchase?");

        }

        System.out.println("Sold Recently: ");

        for (int i = 0; i < this.soldInventory.size(); i++) {
            this.soldInventory.get(i).showCar();
        }

        System.out.println("Still Available: ");

        for (int i = 0; i < this.availableCars.size(); i++) {
            this.availableCars.get(i).showCar();
        }
    }

    private int getIndexOfSelectedCar(String carChoice) {
        for (int i = 0; i < this.availableCars.size(); i++) {
            if (carChoice.equals(this.availableCars.get(i).getMake())) {
                return i;
            }
        }
        return -1;
    }

    private void showAvailableCars() {
        this.availableCars.forEach(aCar -> aCar.showCar());
    }
}

