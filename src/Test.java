import javax.swing.*;

public class Test {
    private JLabel Maxattack;
    private JPanel rootJpanel;
    private JTextField Maxattack1;
    private JLabel minattack;

    public static void main(String[] args) {
        JFrame frame = new JFrame("伤害模拟器");
        frame.setContentPane(new Test().rootJpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
