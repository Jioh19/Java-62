// DrawAPI interface
interface DrawAPI {
    void drawCircle(int radius, int x, int y);
    void drawRectangle(int width, int height, int x, int y);
}

// Concrete implementation classes
class RedPen implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: red, radius: " + radius + ", x: " + x + ", y: " + y + "]");
    }

    @Override
    public void drawRectangle(int width, int height, int x, int y) {
        System.out.println("Drawing Rectangle[ color: red, width: " + width + ", height: " + height + ", x: " + x + ", y: " + y + "]");
    }
}

class BluePen implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: blue, radius: " + radius + ", x: " + x + ", y: " + y + "]");
    }

    @Override
    public void drawRectangle(int width, int height, int x, int y) {
        System.out.println("Drawing Rectangle[ color: blue, width: " + width + ", height: " + height + ", x: " + x + ", y: " + y + "]");
    }
}

// Abstract Shape class
abstract class Shape {
    protected DrawAPI drawAPI;
    
    protected Shape(DrawAPI drawAPI){
        this.drawAPI = drawAPI;
    }
    
    public abstract void draw();    
}

// Concrete Shape classes
class Circle extends Shape {
    private int x, y, radius;

    public Circle(int x, int y, int radius, DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;  
        this.y = y;  
        this.radius = radius;
    }

    public void draw() {
        drawAPI.drawCircle(radius, x, y);
    }
}

class Rectangle extends Shape {
    private int x, y, width, height;

    public Rectangle(int x, int y, int width, int height, DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void draw() {
        drawAPI.drawRectangle(width, height, x, y);
    }
}

// Main class to demonstrate the bridge pattern
public class BridgePatternDemo {
    public static void main(String[] args) {
        Shape redCircle = new Circle(100, 100, 10, new RedPen());
        Shape blueCircle = new Circle(200, 200, 15, new BluePen());
        Shape redRectangle = new Rectangle(50, 50, 100, 75, new RedPen());
        Shape blueRectangle = new Rectangle(150, 150, 80, 60, new BluePen());

        redCircle.draw();
        blueCircle.draw();
        redRectangle.draw();
        blueRectangle.draw();
    }
}
