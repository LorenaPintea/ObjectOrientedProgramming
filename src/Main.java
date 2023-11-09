public class Main {

    public static void main(String[] args) {
        //createObjects();
        //memoryAllocation();
        //browser();
        employee();

    }

    public static void createObjects() {
        var textBox1 = new TextBox();
        textBox1.setText("Box 1");
        System.out.println(textBox1.text);

        var textBox2 = new TextBox();
        textBox2.setText("Box 2");
        System.out.println(textBox2.text);

    }

    public static void memoryAllocation() {
        var textBox1 = new TextBox();
        var textBox2 = textBox1;

        textBox2.setText("Hello World");
        System.out.println(textBox1.text);

    }

    public static void employee() {
        var employee = new Employee(50_000, 30);
        Employee.printNumberOfEmployees();
        int wage = employee.calculateWage(0);

        System.out.println(wage);

    }

    public static void browser() {
        var browser = new Browser();
        browser.navigate("string here");

    }

}
