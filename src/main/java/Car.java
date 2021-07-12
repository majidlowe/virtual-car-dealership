public class Car {

   private String model;

   private String make;

   private Integer price;

   public Car(String make, String model, Integer price) {
        this.make = make;
        this.model = model;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public String getMake() {
        return make;
    }

    public Integer getPrice() {
        return price;
    }

    public void showCarDetails() {
        System.out.print(this.getMake() + " ");
        System.out.print(this.getModel() + " ");
        System.out.println("$" + this.getPrice());
    }

}
