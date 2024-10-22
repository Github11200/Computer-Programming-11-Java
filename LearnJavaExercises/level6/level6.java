class Level6 {
    public static void main(String[] args) {
        final float GST = 0.05f;
        final float PST = 0.07f;

        float priceBeforeTax = 959f;
        float dollarAmountOfGST = priceBeforeTax * GST;
        float dollarAmountOfPST = priceBeforeTax * PST;
        float priceAfterTax = priceBeforeTax + dollarAmountOfGST + dollarAmountOfPST;

        final int numberOfAFromTermMarks = 7;
        final int numberOfBFromTermMarks = 9;
        final int numberOfAFromFinalMarks = 2;
        final int numberOfBFromFinalMarks = 3;

        float moneyEarnedFromTermMarks = (50 * numberOfAFromTermMarks) + (25 * numberOfBFromTermMarks);
        float moneyEarnedFromFinalMarks = (80 * numberOfAFromFinalMarks) + (40 * numberOfBFromFinalMarks);

        float totalMoneyEarned = moneyEarnedFromTermMarks + moneyEarnedFromFinalMarks;
        float differenceBetweenMoneyEarnedAndCostOfIpad = totalMoneyEarned - priceAfterTax;

        System.out.println("Price of iPad (before tax): $" + priceBeforeTax);
        System.out.println("Dollar amount of GST: $" + dollarAmountOfGST);
        System.out.println("Dollar amount of PST: $" + dollarAmountOfPST);
        System.out.println("Price after tax: $" + priceAfterTax);

        System.out.println("Number of A's from term marks: " + numberOfAFromTermMarks);
        System.out.println("Number of B's from term marks: " + numberOfBFromTermMarks);
        System.out.println("Number of A's from final marks: " + numberOfAFromFinalMarks);
        System.out.println("Number of B's from final marks: " + numberOfBFromFinalMarks);

        System.out.println("Money earned from term marks: $" + moneyEarnedFromTermMarks);
        System.out.println("Money earned from final marks: $" + moneyEarnedFromFinalMarks);

        System.out.println("Total money earned: $" + totalMoneyEarned);
        System.out.println("Difference between money earned and cost of iPad: -$" + (-1 * differenceBetweenMoneyEarnedAndCostOfIpad));

        System.out.println("Gwen still needs to earn another $" + (-1 * differenceBetweenMoneyEarnedAndCostOfIpad) + ".");
    }
}