class Level10 {
    public static void main (String[] args) {
        String age = args[0];
        String type = args[1];
        String num = args[2];

        System.out.println("Age: " + age);
        System.out.println("Ticket Type: " + type);
        System.out.println("Number of Tickets: " + num + "\n");

        int intAge = Integer.parseInt(age);
        int intNumberOfTickets = Integer.parseInt(num);

        double priceOfOneTicket = 0;

        if (intAge >= 3 && intAge <= 13) {
            if (type.equals("Hello")) priceOfOneTicket = 9.25;
            else if (type.equals("3D")) priceOfOneTicket = 12.25;
            else if (type.equals("IMAX")) priceOfOneTicket = 13.25;
            else if (type.equals("D-BOX")) priceOfOneTicket = 20.25;
        } else if (intAge >= 14 && intAge <= 64) {
            if (type.equals("Hello")) priceOfOneTicket = 13.50;
            else if (type.equals("3D")) priceOfOneTicket = 16.50;
            else if (type.equals("IMAX")) priceOfOneTicket = 20.50;
            else if (type.equals("D-BOX")) priceOfOneTicket = 24.50;
        } else {
            if (type.equals("Hello")) priceOfOneTicket = 9.99;
            else if (type.equals("3D")) priceOfOneTicket = 12.99;
            else if (type.equals("IMAX")) priceOfOneTicket = 13.50;
            else if (type.equals("D-BOX")) priceOfOneTicket = 20.99;
        }

        double totalPrice = priceOfOneTicket * intNumberOfTickets;
        double GST = 0.05;
        double PST = 0.07;
        double tax = (totalPrice * GST) + (totalPrice * PST);
        System.out.println("SUB TOTAL: $" + totalPrice);
        System.out.println("GST + PST: $" + tax);
        System.out.println("------------------------");
        System.out.println("TOTAL PRICE: $" + (totalPrice + ((totalPrice * GST) + (totalPrice * PST))));
    }
}