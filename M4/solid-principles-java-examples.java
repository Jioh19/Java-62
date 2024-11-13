// 1. Principio de Responsabilidad Única (SRP)

// Mal ejemplo (viola SRP)
class Employee {
    public void calculatePay() { /* ... */ }
    public void saveEmployee() { /* ... */ }
    public void printTimesheet() { /* ... */ }
}

// Buen ejemplo (cumple SRP)
class Employee {
    private String name;
    private int id;
    // ... otros atributos y métodos relacionados con el empleado
}

class PayrollCalculator {
    public void calculatePay(Employee employee) { /* ... */ }
}

class EmployeeRepository {
    public void save(Employee employee) { /* ... */ }
}

class TimesheetPrinter {
    public void print(Employee employee) { /* ... */ }
}

// 2. Principio Abierto/Cerrado (OCP)

// Mal ejemplo (viola OCP)
class Rectangle {
    public double width;
    public double height;
}

class AreaCalculator {
    public double calculateArea(Rectangle rectangle) {
        return rectangle.width * rectangle.height;
    }
    // Si queremos añadir un nuevo tipo de forma, tenemos que modificar esta clase
}

// Buen ejemplo (cumple OCP)
interface Shape {
    double calculateArea();
}

class Rectangle implements Shape {
    private double width;
    private double height;

    @Override
    public double calculateArea() {
        return width * height;
    }
}

class Circle implements Shape {
    private double radius;

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// Ahora podemos añadir nuevas formas sin modificar el calculador de área
class AreaCalculator {
    public double calculateArea(Shape shape) {
        return shape.calculateArea();
    }
}

// 3. Principio de Sustitución de Liskov (LSP)

// Mal ejemplo (viola LSP)
class Bird {
    public void fly() { /* ... */ }
}

class Penguin extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Penguins can't fly");
    }
}

// Buen ejemplo (cumple LSP)
interface FlyingBird {
    void fly();
}

interface SwimmingBird {
    void swim();
}

class Sparrow implements FlyingBird {
    @Override
    public void fly() { /* ... */ }
}

class Penguin implements SwimmingBird {
    @Override
    public void swim() { /* ... */ }
}

// 4. Principio de Segregación de la Interfaz (ISP)

// Mal ejemplo (viola ISP)
interface Worker {
    void work();
    void eat();
    void sleep();
}

class Human implements Worker {
    public void work() { /* ... */ }
    public void eat() { /* ... */ }
    public void sleep() { /* ... */ }
}

class Robot implements Worker {
    public void work() { /* ... */ }
    public void eat() { throw new UnsupportedOperationException(); }
    public void sleep() { throw new UnsupportedOperationException(); }
}

// Buen ejemplo (cumple ISP)
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

interface Sleepable {
    void sleep();
}

class Human implements Workable, Eatable, Sleepable {
    public void work() { /* ... */ }
    public void eat() { /* ... */ }
    public void sleep() { /* ... */ }
}

class Robot implements Workable {
    public void work() { /* ... */ }
}

// 5. Principio de Inversión de Dependencia (DIP)

// Mal ejemplo (viola DIP)
class LightBulb {
    public void turnOn() { /* ... */ }
    public void turnOff() { /* ... */ }
}

class Switch {
    private LightBulb bulb;

    public Switch() {
        this.bulb = new LightBulb();
    }

    public void operate() {
        // ... decide whether to turn on or off
        bulb.turnOn();
    }
}

// Buen ejemplo (cumple DIP)
interface Switchable {
    void turnOn();
    void turnOff();
}

class LightBulb implements Switchable {
    public void turnOn() { /* ... */ }
    public void turnOff() { /* ... */ }
}

class Fan implements Switchable {
    public void turnOn() { /* ... */ }
    public void turnOff() { /* ... */ }
}

class Switch {
    private Switchable device;

    public Switch(Switchable device) {
        this.device = device;
    }

    public void operate() {
        // ... decide whether to turn on or off
        device.turnOn();
    }
}
