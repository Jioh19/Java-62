// Superclass
abstract class Vehicle {
    private String brand;

    public Vehicle(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    // Abstract method to be implemented by subclasses
    public abstract void move();
}

// Subclass Car
class Car extends Vehicle {
    public Car(String brand) {
        super(brand);
    }

    @Override
    public void move() {
        System.out.println(getBrand() + " car is driving on the road.");
    }
}

// Subclass Boat
class Boat extends Vehicle {
    public Boat(String brand) {
        super(brand);
    }

    @Override
    public void move() {
        System.out.println(getBrand() + " boat is sailing on the water.");
    }
}

// Subclass Airplane
class Airplane extends Vehicle {
    public Airplane(String brand) {
        super(brand);
    }

    @Override
    public void move() {
        System.out.println(getBrand() + " airplane is flying in the sky.");
    }
}

// Main class to demonstrate polymorphism
public class VehicleDemo {
    public static void main(String[] args) {
        // Create an array of Vehicle objects
        Vehicle[] vehicles = new Vehicle[3];
        vehicles[0] = new Car("Toyota");
        vehicles[1] = new Boat("Yamaha");
        vehicles[2] = new Airplane("Boeing");

        // Demonstrate polymorphism
        for (Vehicle vehicle : vehicles) {
            vehicle.move();  // This calls the move() method of the respective subclass
        }
    }
}
