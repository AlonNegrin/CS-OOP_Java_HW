import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;



    public class Calculator extends JFrame {

        private JTextField firstNumber;
        private JTextField secondNumber;
        private JTextField result;
        private JButton add;
        private JButton clear;
        private JButton exit;

        public Calculator() {
            this.getContentPane().setLayout(new BorderLayout());
            calculatorForm();

            JPanel upperPanel = new JPanel();
            upperPanel.setPreferredSize(new Dimension(200, 20));
            add(upperPanel, BorderLayout.NORTH);

            JPanel leftPanel = new JPanel();
            leftPanel.setPreferredSize(new Dimension(20, 100));
            add(leftPanel, BorderLayout.WEST);

            JPanel downPanel = new JPanel();
            downPanel.setPreferredSize(new Dimension(200, 50));
            add(downPanel, BorderLayout.SOUTH);
            exit = new JButton("Exit");
            downPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 50,20));
            downPanel.add(exit, BorderLayout.EAST);

            JPanel rightPanel = new JPanel();
            rightPanel.setPreferredSize(new Dimension(20, 100));
            add(rightPanel, BorderLayout.EAST);

            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            pack();
            setVisible(false);
            repaint();
        }

        private void calculatorForm() {
            JPanel jPanel = new JPanel();
            GridLayout gridLayout = new GridLayout(4, 2);
            gridLayout.setVgap(5);
            gridLayout.setHgap(5);
            jPanel.setLayout(gridLayout);
            jPanel.setPreferredSize(new Dimension(800,640));
            jPanel.setMaximumSize(new Dimension(1640,1024));
            jPanel.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Color.red, 5), // outer border
                    BorderFactory.createEmptyBorder(5,5,5,5)));

            formInput(jPanel);
            formInteraction(jPanel);
        }

        private void formInput(JPanel jPanel) {
            Border inputBorder = BorderFactory.createLineBorder(Color.blue, 1);
            Label firstNumber = new Label("First number:");
            Label secondNumber = new Label("Second number:");
            Label result = new Label("First number:");

            this.firstNumber = new JTextField();
            this.firstNumber.setBorder(inputBorder);

            this.secondNumber = new JTextField();
            this.secondNumber.setBorder(inputBorder);

            this.result = new JTextField();
            this.result.setBorder(inputBorder);

            jPanel.add(firstNumber);
            jPanel.add(this.firstNumber);
            jPanel.add(secondNumber);
            jPanel.add(this.secondNumber);
            jPanel.add(result);
            jPanel.add(this.result);
            add(jPanel, BorderLayout.CENTER);
        }

        private void formInteraction(JPanel jPanel) {
            JPanel addClearPanel = new JPanel();
            add = new JButton("Add");
            clear = new JButton("Clear");
            addClearPanel.add(add);
            addClearPanel.add(clear);
            jPanel.add(new JPanel());
            jPanel.add(addClearPanel);
        }
    }

