import javax.swing.*;

public class ToolMy {

    public static JTextField jtext(int x, int y, int a, int b) {
        JTextField test1 = new JTextField(20);
        test1.setBounds(x,y,a,b);
        return test1;
    }

    public static JLabel jlabel(int x, int y, int a, int b,String s) {
        JLabel test2 = new JLabel(s);
        test2.setBounds(x,y,a,b);
        return test2;
    }
}
