package level17;

class level17 {
    public static void main(String[] args) {
        double userMass = Double.parseDouble(args[0]) * 0.45359237;
        String planetName = args[1];

        double planetMass = 0;
        double planetDiameter = 0;
        double planetDayLength = 0;

        double radius = 0;
        double surfaceArea = 0;
        double surfaceGravity = 0;
        double userWeight = 0;
        final double G = 6.67408E-11;

        switch (planetName) {
            case "Mercury":
                planetMass = 0.3285E24;
                planetDiameter = 4879E3;
                planetDayLength = 175.942;
                break;
            case "Venus":
                planetMass = 4.867E24;
                planetDiameter = 12104E3;
                planetDayLength = 116.75;
                break;
            case "Earth":
                planetMass = 5.972E24;
                planetDiameter = 12756E3;
                planetDayLength = 1;
                radius = planetDiameter / 2;
                surfaceArea = 4 * Math.PI * Math.pow(radius, 2);
                surfaceGravity = (G * planetMass) / Math.pow(radius, 2);
                userWeight = surfaceGravity * userMass;

                System.out.println("Object: " + planetName);
                System.out.println("Mass: " + planetMass + " kg");
                System.out.println("Radius: " + (planetDiameter / 2) + " m");
                System.out.println("Surface Area: " + surfaceArea + " m^2");
                System.out.println("Surface Gravity: " + surfaceGravity + " m/s^2");
                System.out.println("Length of Day: " + (planetDayLength * 24) + " hrs");
                System.out.println("Your mass: " + userMass + " kg");
                System.out.println("Your weight: " + userWeight + " Newtons");
            case "Moon":
                planetName = "Moon";
                planetMass = 0.073E24;
                planetDiameter = 3475E3;
                planetDayLength = 29.529;
                break;
            case "Mars":
                planetMass = 0.639E24;
                planetDiameter = 6792E3;
                planetDayLength = 1.029;
                break;
            case "Jupiter":
                planetMass = 1898E24;
                planetDiameter = 142984E3;
                planetDayLength = 0.413;
                break;
            case "Saturn":
                planetMass = 568.3E24;
                planetDiameter = 120536E3;
                planetDayLength = 0.446;
                break;
            case "Uranus":
                planetMass = 86.81E24;
                planetDiameter = 51118E3;
                planetDayLength = 0.717;
                break;
            case "Neptune":
                planetMass = 102E24;
                planetDiameter = 49528E3;
                planetDayLength = 0.671;
                break;
            case "Pluto":
                planetMass = 0.013E24;
                planetDiameter = 2370E3;
                planetDayLength = 6.388;
                break;
            default:
                System.out.println("ERROR: INVALID PLANET");
                return;
        }

        radius = planetDiameter / 2;
        surfaceArea = 4 * Math.PI * Math.pow(radius, 2);
        surfaceGravity = (G * planetMass) / Math.pow(radius, 2);
        userWeight = surfaceGravity * userMass;

        System.out.println("Object: " + planetName);
        System.out.println("Mass: " + planetMass + " kg");
        System.out.println("Radius: " + (planetDiameter / 2) + " m");
        System.out.println("Surface Area: " + surfaceArea + " m^2");
        System.out.println("Surface Gravity: " + surfaceGravity + " m/s^2");
        System.out.println("Length of Day: " + (planetDayLength * 24) + " hrs");
        System.out.println("Your mass: " + userMass + " kg");
        System.out.println("Your weight: " + userWeight + " Newtons");
    }
}
