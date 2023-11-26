package mortgagecalculatorobjectoriented;

import java.text.NumberFormat;

public class Printing {
    private final Mortgage mortgage;

    public Printing(Mortgage mortgage) {
        this.mortgage = mortgage;
    }

    public  void printMortgage() {
        double value = mortgage.calculateMortgage();
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(value);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + mortgageFormatted);
    }

    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (short month = 1; month <= mortgage.getYears() * Main.MONTHS_IN_YEAR; month++) {
            double balance = mortgage.calculateBalance(month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }
}
