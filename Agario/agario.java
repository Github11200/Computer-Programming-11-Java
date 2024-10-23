import java.awt.*;
import java.text.DecimalFormat;
import java.util.Random;

class Circle {
	// CONSTANTS
	final int MAX_SPEED = 10;
	final int INIT_RADIUS = 12;
	
	// MEMBERS
	private String userName;
	private int speed;
	private int radius;
	private Color color; // need import statement to create color object
	private int xPos;
	private int yPos;
	
	// CONSTRUCTOR
	Circle (String name, int x, int y) {
		Random random = new Random();
		Color randomColor = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));

		userName = name;
		speed = MAX_SPEED;
		radius = INIT_RADIUS;
		color = randomColor;
		
		xPos = x;
		yPos = y;
	}
	
	// METHODS
	void incrementX() { ++xPos; }
	void decrementX() { --xPos; }
	void incrementY() { ++yPos; }
	void decrementY() { --yPos; }
	
	boolean setRadius (int val) {
		radius = val;
		if (radius >= INIT_RADIUS) return true;
		return false;
	}
	boolean setColor (int r, int g, int b) {
		if (r < 0 || g < 0 || b < 0 || r > 255 || g > 255 || b > 255) return false;
		color = new Color(r, g, b);
		return true;
	}
	boolean setColor (Color c) {
		if (c == null) return false;
		color = c;
		return true;
	}
	
	boolean updateSpeed () {
		int change = (int)(Math.log(radius/INIT_RADIUS)/Math.log(2));
		if (change > 0) {
			speed -= change;
			return true;
		}
		else
			return false;
	}
	
	int getSpeed() { return speed; }
	int getRadius() { return radius; }
	String getUserName() { return userName; }
	Color getColor() { return color; }
	
	int diameter() { return radius * 2; }
	double area() { return Math.PI * Math.pow(radius, 2); }
	double circumference() { return 2 * Math.PI * radius; }
	
	boolean eat (Circle c) {
		if (c.radius < radius) {
			radius += c.radius;
			c.radius = 0;
			updateSpeed();
			c.reset();
			return true;
		}
		return false;
	}
	
	void display() {
		
		System.out.println("=======================================================");
		System.out.println("Class members");
		System.out.println("=======================================================");
		System.out.println("Username: " + getUserName());
		System.out.println("Speed: " + getSpeed());
		System.out.println("Radius: " + getRadius());
		System.out.println("Color: " + getColor());
		System.out.println("X position: " + xPos);
		System.out.println("Y position: " + yPos);
		System.out.println("Diameter: " + diameter());
		System.out.println("Area: " + String.format("%.2f", area()));
		System.out.println("Circumference: " + String.format("%.2f", circumference()) + "\n");
	}
	
	void reset() {
		userName = "dead";
		speed = 0;
		radius = 0;
		color = new Color(0, 0, 0);
		xPos = -1;
		yPos = -1;
	}
	
	public static void main (String[] args) {
		Circle c1 = new Circle("user 1", 15, 15);
		Circle c2 = new Circle("user 2", 15, 15);
		
		c1.incrementX();
		c1.incrementX();
		c1.decrementX();
		c1.incrementY();
		c1.incrementY();
		c1.decrementY();
		
		c1.setColor(new Color(255, 255, 255));
		c2.setColor(0, 0, 0);
		
		c1.setRadius(50);
		c2.setRadius(45);
		
		c1.display();
		c2.display();
		System.out.println("************************* Can c2 eat c1: " + c1.eat(c2) + " *************************\n");
		c1.display();
		c2.display();
	}
}