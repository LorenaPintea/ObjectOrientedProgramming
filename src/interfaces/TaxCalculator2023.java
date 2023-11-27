package interfaces;

public class TaxCalculator2023 implements TaxCalculator {
    private double taxableIncome;

    public TaxCalculator2023(double taxableIncome) {
        this.taxableIncome = taxableIncome;
    }

    @Override
    public double calculateTax() {
        return this.taxableIncome * 0.2;
    }
}
