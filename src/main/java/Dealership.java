import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Dealership {
    private List<Car> availableCars;
    private List<Car> soldInventory;
    double totalCommission = 0;

    public Dealership() {
        this.availableCars = new ArrayList();
        this.soldInventory = new ArrayList();
    }

    public void stockInventory() {
        Car volt = new Car("Chevy", "Volt", 4000);
        Car porsche = new Car("Porsche", "911", 200000);
        Car sienna = new Car("Toyota", "Sienna", 30000);

        this.availableCars.add(volt);
        this.availableCars.add(porsche);
        this.availableCars.add(sienna);
    }

    public void runSalesAppointments() {
        int commission;

        stockInventory();

        while(availableCars.size() > 0){
            appointmentTransaction();
        }

        commission = calculateSalesCommission();
        System.out.println("Sorry no more cars!" );
        System.out.println("WooWee!  Here's the sales commission: $" + commission);

    }

    private int calculateSalesCommission() {
        double commissionPercentage = .2;
        this.soldInventory.forEach(soldCar -> totalCommission += soldCar.getPrice() * commissionPercentage);
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

    private void selectCarsByBudget(){
        System.out.println("Awesome! Let me know what your budget is...");

        Scanner scanner = new Scanner(System.in);
        String userBudget = scanner.nextLine();

        calculateBudget(Integer.parseInt(userBudget));
    }

    private void calculateBudget(int userBudget){
        if(userBudget < 4000 ){
            System.out.println("Sorry, nothing available for that price budget");
        } else if(userBudget >= 4000 && userBudget <= 29999){
            System.out.println("Volt");
        } else if(userBudget >= 30000 && userBudget <= 199999){
            System.out.println("Toyota | Volt");
        } else if(userBudget > 200000 ){
            System.out.println("Porsche | Toyota | Volt");
        } else{
            System.out.println("Something went wrong ...");
        }
    }

    private void greetCustomerAndShowInventory(){
        System.out.println("Salesperson: Welcome to the Syed's Dealership!  \n\nWould you like to view by MAKE or BUDGET?");

        Scanner scanner = new Scanner(System.in);
        String userShoppingOptions = scanner.nextLine();

        //if customer wants to select by MAKE then run showAvailableCars();
        if(userShoppingOptions.equals("MAKE")){
            showAvailableCars();
        }

        //if customer wants to select by BUDGET then run selectCarsByBudget();
        if(userShoppingOptions.equals("BUDGET")){
            selectCarsByBudget();
        }

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

