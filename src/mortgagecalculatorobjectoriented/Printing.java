package mortgagecalculatorobjectoriented;

import java.text.NumberFormat;

public class Printing {
    private Mortgage mortgage;

    private final NumberFormat currency = NumberFormat.getCurrencyInstance();

    public Printing(Mortgage mortgage) {
        this.mortgage = mortgage;
    }

    public void printMortgage() {
        double value = mortgage.calculateMortgage();
        String mortgageFormatted = currency.format(value);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + mortgageFormatted);
    }

    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");

        for (double balance : mortgage.getRemainingBalances())
            System.out.println(currency.format(balance));

    }
}
