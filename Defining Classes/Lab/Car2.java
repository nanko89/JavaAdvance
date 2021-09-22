

import java.util.List;

public class Car {
   private String brand;
   private String model;
   private int horsePower;


   public Car(String brand, String model, int horsePower){
       this(brand,model);
       this.horsePower = horsePower;
   }

   public Car(String brand, String model){
       this(brand);
       this.model = model;
   }

   public Car(String brand){
       this.brand = brand;
   }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public String toString (){

       return String.format("The car is: %s %s - %d HP.%n",
               this.getBrand(),
               this.getModel() != null ? this.getModel() : "unknown",
               this.getHorsePower() != 0 ? this.getHorsePower() : -1);
    }

}
