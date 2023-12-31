package mortgagecalculatorobjectoriented;

public class Main {

    public static void main(String[] args) {
        float principal = (float) Console.readNumber("Principal: ", 1000, 1_000_000);
        float annualInterest = (float) Console.readNumber("Annual Interest Rate: ", 1, 30);
        byte years = (byte) Console.readNumber("Period (Years): ", 1, 30);

        var mortgage = new Mortgage(principal, annualInterest, years);
        var printMortgage = new Printing(mortgage);

        printMortgage.printMortgage();
        printMortgage.printPaymentSchedule();
    }
}
