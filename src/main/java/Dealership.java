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

    public void stockInventory() {
        Car volt = new Car("Chevy", "Volt", 4017);
        Car porsche = new Car("Porsche", "911", 200000);
        Car sienna = new Car("Toyota", "Sienna", 30000);

        this.availableCars.add(volt);
        this.availableCars.add(porsche);
        this.availableCars.add(sienna);
    }

    public void runSalesAppointments() {
        stockInventory();

        while(availableCars.size() > 0){
            appointmentTransaction();
        }
        System.out.println("Sorry no more cars!" );
        int commission = calculateSalesCommission();
        System.out.println("Commission: $" + commission);

    }

    double totalCommission = 0;
    private int calculateSalesCommission() {
        this.soldInventory.forEach(soldCar -> totalCommission += soldCar.getPrice() * .2);
        return (int) totalCommission;
    }

    private int getIndexOfSelectedCar(String carChoice) {
        for (int i = 0; i < this.availableCars.size(); i++) {
            if (carChoice.equals(this.availableCars.get(i).getMake())) {
                System.out.println("i: " + i);
                return i;
            }
        }
        return -1;
    }

    private void showAvailableCars() {
        this.availableCars.forEach(availableCar -> availableCar.showCarDetails());
    }

    private void showSoldCars() {
        this.soldInventory.forEach(soldCar -> soldCar.showCarDetails());
    }

    private void greetCustomerAndShowInventory(){
        System.out.println("Salesperson: Welcome to the dealership!  \n\nWhich car would you like to purchase?");
        showAvailableCars();
        System.out.println("Don't see what you like?  Type Q to decline.");
    }

    private void appointmentTransaction() {
        greetCustomerAndShowInventory();

        Scanner scanner = new Scanner(System.in);
        String carChoice = scanner.nextLine();

        if(carChoice.equals("Q")){
            System.out.println("No Problemo!  Go catch a bus - I have cars to sell!");
            return;
        }

        System.out.println("Great!  You selected " + carChoice);

        int carChoiceIndex = getIndexOfSelectedCar(carChoice);

        System.out.println("Salesperson: Great! Would you like to purchase the " + carChoice + " ? Please type Y or N");
        String buyOrNot = scanner.nextLine();

        if (buyOrNot.equals("Y")) {
            this.soldInventory.add(this.availableCars.get(carChoiceIndex));
            this.availableCars.remove(this.availableCars.get(carChoiceIndex));
            System.out.print("Sold Recently: \n");
            showSoldCars();
        }

        if(buyOrNot.equals("N")) {
            System.out.print("Okay - no prob!\n");
        }
    }

}

