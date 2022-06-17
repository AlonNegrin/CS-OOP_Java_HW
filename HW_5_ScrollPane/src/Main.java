import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Component cp = calc.getContentPane();
        MyScrollPane scrollPane = new MyScrollPane(cp);
    }
}