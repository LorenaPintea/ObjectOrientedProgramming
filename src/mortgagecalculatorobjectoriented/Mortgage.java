package mortgagecalculatorobjectoriented;

import java.text.NumberFormat;

public class Mortgage {
    private float principal;
    private float annualInterest;
    private byte years;

    public Mortgage(float principal, float annualInterest, byte years) {
        setPrincipal(principal);
        setAnnualInterest(annualInterest);
        setYears(years);
    }

    public double calculateBalance(short numberOfPaymentsMade) {
        float monthlyInterest = this.annualInterest / Main.PERCENT / Main.MONTHS_IN_YEAR;
        float numberOfPayments = this.years * Main.MONTHS_IN_YEAR;

        return this.principal * (Math.pow(1 + monthlyInterest, numberOfPayments)
                - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

    }

    public double calculateMortgage() {

        float monthlyInterest = this.annualInterest / Main.PERCENT / Main.MONTHS_IN_YEAR;
        float numberOfPayments = this.years * Main.MONTHS_IN_YEAR;

        return this.principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

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

    public byte getYears() {
        return years;
    }
}