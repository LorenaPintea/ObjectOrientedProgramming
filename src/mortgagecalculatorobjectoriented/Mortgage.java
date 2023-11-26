package mortgagecalculatorobjectoriented;

import java.text.NumberFormat;

public class Mortgage {
    private final static byte MONTHS_IN_YEAR = 12;
    private final static byte PERCENT = 100;
    private float principal;
    private float annualInterest;
    private byte years;

    public Mortgage(float principal, float annualInterest, byte years) {
        setPrincipal(principal);
        setAnnualInterest(annualInterest);
        setYears(years);
    }

    public double calculateBalance(short numberOfPaymentsMade) {
        float monthlyInterest = getMonthlyInterest();
        float numberOfPayments = getNumberOfPayments();

        return this.principal * (Math.pow(1 + monthlyInterest, numberOfPayments)
                - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

    }

    public double calculateMortgage() {

        float monthlyInterest = getMonthlyInterest();
        float numberOfPayments = getNumberOfPayments();

        return this.principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

    }

    public double[] getRemainingBalances() {
        var balances = new double[getNumberOfPayments()];

        for (short month = 1; month <= getNumberOfPayments(); month++) {
            balances[month - 1] = calculateBalance(month);
        }

        return balances;
    }

    private int getNumberOfPayments() {
        return this.years * MONTHS_IN_YEAR;
    }

    private float getMonthlyInterest() {
        return this.annualInterest / PERCENT / MONTHS_IN_YEAR;
    }

    private void setPrincipal(float principal) {
        this.principal = principal;
    }

    private void setAnnualInterest(float annualInterest) {
        this.annualInterest = annualInterest;
    }

    private void setYears(byte years) {
        this.years = years;
    }
}