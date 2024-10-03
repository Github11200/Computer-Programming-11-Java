package level17;

public class level17 {
    public static void main(String[] args) {
        double userMass = Double.parseDouble(args[0]) / 2.205;
        String planetName = args[1];

        double planetMass = 0;
        double planetDiameter = 0;
        double planetDayLength = 0;

        switch (planetName) {
            case "Mercury":
                planetMass = 0.3285E24;
                planetDiameter = 4879E3;
                planetDayLength = 175.942;
            case "Venus":
                planetMass = 4.867E24;
                planetDiameter = 12104E3;
                planetDayLength = 116.75;
            case "Earth":
                planetMass = 5.972E24;
                planetDiameter = 12756E3;
                planetDayLength = 1;
            case "Moon":
                planetMass = 0.073E24;
                planetDiameter = 3475E3;
                planetDayLength = 29.529;
            case "Mars":
                planetMass = 0.639E24;
                planetDiameter = 6792E3;
                planetDayLength = 1.029;
            case "Jupiter":
                planetMass = 1898E24;
                planetDiameter = 142984E3;
                planetDayLength = 0.413;
            case "Saturn":
                planetMass = 568.3E24;
                planetDiameter = 120536E3;
                planetDayLength = 0.446;
            case "Uranus":
                planetMass = 86.81E24;
                planetDiameter = 51118E3;
                planetDayLength = 0.717;
            case "Neptune":
                planetMass = 102E24;
                planetDiameter = 49528E3;
                planetDayLength = 0.671;
            case "Pluto":
                planetMass = 0.013;
                planetDiameter = 2370E3;
                planetDayLength = 6.388;
        }

        double radius = planetDiameter / 2;
        double surfaceArea = 4 * Math.PI * Math.pow(radius, 2);
        double surfaceGravity = (6.67408E-11 * planetMass) / Math.pow(radius, 2);
        double userWeight = surfaceGravity * userMass;

        System.out.println("Object: " + planetName);
        System.out.println("Mass: " + planetMass);
        System.out.println("Radius: " + (planetDiameter / 2));
        System.out.println("Surface Area: " + surfaceArea);
        System.out.println("Surface Gravity: " + surfaceGravity);
        System.out.println("Length of Day: " + planetDayLength + " hrs");
        System.out.println("Your mass: " + userMass + " kg");
        System.out.println("Your weight: " + userWeight + " Newtons");
    }
}
