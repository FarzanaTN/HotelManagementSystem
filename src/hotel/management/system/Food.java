package hotel.management.system;

public class Food {
    private int id;
    private String name;
    private String cuisine;
    private double price;
    private String dietaryRestrictions;
    private String description;

    public Food(int id, String name, double price) {
        this.id = id;
        this.name = name;
       // this.cuisine = cuisine;
        this.price = price;
      //  this.dietaryRestrictions = dietaryRestrictions;
       // this.description = description;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Price: $" + price
                ;
    }
}


