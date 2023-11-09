public class Employee {
    public static int numberOfEmployees;
    private int baseSalary;
    private int hourlyRate;

    public Employee(int baseSalary) {
        this(baseSalary, 0);
    }

    public Employee(int baseSalary, int hourlyRate) {
        setBaseSalary(baseSalary);
        setHourlyRate(hourlyRate);
        numberOfEmployees++;
    }

    public static void printNumberOfEmployees() {
        System.out.println(numberOfEmployees);
    }

    private static int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    private static void setNumberOfEmployees(int numberOfEmployees) {
        Employee.numberOfEmployees = numberOfEmployees;
    }

    public int calculateWage(int extraHours) {

        return this.baseSalary + (this.hourlyRate * extraHours);
    }

    private int calculateWage() {

        return calculateWage(0);
    }

    private int getBaseSalary() {
        return baseSalary;
    }

    private void setBaseSalary(int baseSalary) {
        if (baseSalary <= 0)
            throw new IllegalArgumentException("Salary can't be less than 0");

        this.baseSalary = baseSalary;
    }

    private int getHourlyRate() {
        return hourlyRate;
    }

    private void setHourlyRate(int hourlyRate) {
        if (hourlyRate < 0)
            throw new IllegalArgumentException("Hourly rate can't be less than 0");

        this.hourlyRate = hourlyRate;
    }
}
