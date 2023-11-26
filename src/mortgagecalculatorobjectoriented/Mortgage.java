package mortgagecalculatorobjectoriented;

import java.text.NumberFormat;

public class Mortgage implements Printing {
    private final static byte MONTHS_IN_YEAR = 12;
    private final static byte PERCENT = 100;

    private final static short MIN_PRINCIPAL = 1000;
    private final static int MAX_PRINCIPAL = 1_000_000;

    private final static byte MIN_INTEREST_RATE_AND_YEARS = 1;
    private final static byte MAX_INTEREST_RATE_AND_YEARS = 30;


    private float principal;
    private float annualInterest;
    private byte years;

    public Mortgage(float principal, float annualInterest, byte years) {
        setPrincipal(principal);
        setAnnualInterest(annualInterest);
        setYears(years);
    }

    private double calculateBalance(short numberOfPaymentsMade) {
        float monthlyInterest = this.annualInterest / PERCENT / MONTHS_IN_YEAR;
        float numberOfPayments = this.years * MONTHS_IN_YEAR;

        return this.principal * (Math.pow(1 + monthlyInterest, numberOfPayments)
                - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

    }

    private double calculateMortgage() {

        float monthlyInterest = this.annualInterest / PERCENT / MONTHS_IN_YEAR;
        float numberOfPayments = this.years * MONTHS_IN_YEAR;

        return this.principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

    }

    private void setPrincipal(float principal) {
        if (principal < MIN_PRINCIPAL || principal > MAX_PRINCIPAL)
            throw new IllegalArgumentException("Principal must be between 1.000 and 1.000.000");

        this.principal = principal;
    }

    private void setAnnualInterest(float annualInterest) {
        if (annualInterest < MIN_INTEREST_RATE_AND_YEARS || annualInterest > MAX_INTEREST_RATE_AND_YEARS)
            throw new IllegalArgumentException("The annual interest must be between 1 and 30");

        this.annualInterest = annualInterest;
    }

    private void setYears(byte years) {
        if (years < MIN_INTEREST_RATE_AND_YEARS || years > MAX_INTEREST_RATE_AND_YEARS)
            throw new IllegalArgumentException("The annual interest must be between 1 and 30");

        this.years = years;
    }


    @Override
    public void printMortgage() {
        double mortgage = calculateMortgage();
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + mortgageFormatted);
    }

    @Override
    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");

        for (short month = 1; month <= this.years * MONTHS_IN_YEAR; month++) {
            double balance = calculateBalance(month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }
}
