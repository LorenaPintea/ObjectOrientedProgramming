package inheritance;

public class Main {
    public static void main(String[] args) {

        UIControl[] controls = {new TextBox(), new CheckBox(), new CheckBox()};
        for (var control : controls)
            control.render();

//        var box1 = new TextBox();
//        var control = new UIControl();
//
//        show(control);
//        show(box1);
//
//        var point1 = new Point(1, 2);
//        var point2 = new Point(1, 2);
//
//        System.out.println(point1.equals(point2));
//        System.out.println(point1 == point2);
//
//        System.out.println(point1.hashCode());
//        System.out.println(point2.hashCode());
    }

//    public static void show(UIControl control) {
//        if (control instanceof TextBox textBox) {
//            textBox.setText("Hi Lo!");
//        }
//
//        System.out.println(control);
//
//    }
}
