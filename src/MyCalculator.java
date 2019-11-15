import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyCalculator {
    public static void main(String[] args) {
        // 创建 JFrame 实例
        JFrame frame = new JFrame("伤害模拟器1.0(吴广林)  ");
        // Setting the width and height of frame
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* 创建面板，这个类似于 HTML 的 div 标签
         * 我们可以创建多个面板并在 JFrame 中指定位置
         * 面板中我们可以添加文本字段，按钮及其他组件。
         */
        JPanel panel = new JPanel();
        // 添加面板
        frame.add(panel);
        /*
         * 调用用户定义的方法并添加组件到面板
         */
        placeComponents(panel);

        // 设置界面可见
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
         // 这边设置布局为 null
        panel.setLayout(null);

        //人物攻击
        JLabel people1=ToolMy.jlabel(10,20,80,25,"人物攻击:");
        panel.add(people1);
        JTextField people2=ToolMy.jtext(80,20,50,25);
        panel.add(people2);
        JTextField people3=ToolMy.jtext(150,20,50,25);
        panel.add(people3);

        //攻击力宝石
        JLabel attackStone1=ToolMy.jlabel(220,20,80,25,"攻击宝石:");
        panel.add(attackStone1);
        JTextField attackStone2=ToolMy.jtext(300,20,50,25);
        panel.add(attackStone2);
        //骑士加成
        JLabel knight1=ToolMy.jlabel(400,20,80,25,"骑士加成:");
        panel.add(knight1);
        JTextField knight2=ToolMy.jtext(460,20,50,25);
        panel.add(knight2);
        //技能系数
        JLabel skill1=ToolMy.jlabel(530,20,80,25,"技能系数:");
        panel.add(skill1);
        JTextField skill2=ToolMy.jtext(600,20,50,25);
        panel.add(skill2);
        //a幻兽攻击
        JLabel ababy1=ToolMy.jlabel(10,50,160,25,"a幻兽攻击:");
        panel.add(ababy1);
        JTextField ababy2=ToolMy.jtext(80,50,50,25);
        panel.add(ababy2);
        JTextField ababy3=ToolMy.jtext(150,50,50,25);
        panel.add(ababy3);

        //b幻兽攻击
        JLabel bbaby1=ToolMy.jlabel(10,80,160,25,"b幻兽攻击:");
        panel.add(bbaby1);
        JTextField bbaby2=ToolMy.jtext(80,80,50,25);
        panel.add(bbaby2);
        JTextField bbaby3=ToolMy.jtext(150,80,50,25);
        panel.add(bbaby3);

        //c幻兽攻击
        JLabel cbaby1=ToolMy.jlabel(10,110,160,25,"c幻兽攻击:");
        panel.add(cbaby1);
        JTextField cbaby2=ToolMy.jtext(80,110,50,25);
        panel.add(cbaby2);
        JTextField cbaby3=ToolMy.jtext(150,110,50,25);
        panel.add(cbaby3);

        //元素属性
        JLabel element1=ToolMy.jlabel(10,140,160,25,"元素属性:");
        panel.add(element1);
        JTextField element2=ToolMy.jtext(80,140,50,25);
        panel.add(element2);

        //人物神圣伤害
        JLabel godhurt1=ToolMy.jlabel(140,140,160,25,"人物神伤:");
        panel.add(godhurt1);
        JTextField godhurt2=ToolMy.jtext(200,140,50,25);
        panel.add(godhurt2);

        //幻兽神伤
        JLabel babyhurt1=ToolMy.jlabel(260,140,160,25,"幻兽神伤:");
        panel.add(babyhurt1);
        JTextField babyhurt2=ToolMy.jtext(320,140,50,25);
        panel.add(babyhurt2);

        //暴击率
        JLabel crit1=ToolMy.jlabel(380,140,160,25,"暴击率:");
        panel.add(crit1);
        JTextField crit2=ToolMy.jtext(440,140,50,25);
        panel.add(crit2);

        //暴击值
        JLabel critVaule1=ToolMy.jlabel(500,140,160,25,"暴击值:");
        panel.add(critVaule1);
        JTextField critValue2=ToolMy.jtext(560,140,50,25);
        panel.add(critValue2);


        // 创建计算按钮
        JButton cButton = new JButton("计算");
        cButton.setBounds(10, 200, 80, 25);
        panel.add(cButton);



        //显示值
        JLabel jtext1=ToolMy.jlabel(10,230,160,25,"人物神圣伤害)");
        panel.add(jtext1);
        JLabel jtext2=ToolMy.jlabel(250,230,300,25,"人物平均伤害（神伤和暴击转换后）");
        panel.add(jtext2);
        JLabel jtext3=ToolMy.jlabel(10,300,300,25,"幻兽普通伤害（不算暴击）");
        panel.add(jtext3);
        JLabel jtext4=ToolMy.jlabel(250,300,300,25,"幻兽平均伤害（神伤和暴击转换后）");
        panel.add(jtext4);
        JTextField value1=ToolMy.jtext(10,260,100,25);
        panel.add(value1);
        JTextField value2=ToolMy.jtext(250,260,100,25);
        panel.add(value2);
        JTextField value3=ToolMy.jtext(10,320,100,25);
        panel.add(value3);
        JTextField value4=ToolMy.jtext(250,320,100,25);
        panel.add(value4);
        cButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //接受各个值并且加入运算逻辑
                //计算人物伤害
                float min=Float.parseFloat(people2.getText());
                float peopleMax=Float.parseFloat(people3.getText());
                float peoplemin= (peopleMax-min)/2+min;
                //人物平均攻击
                float peoplehurt= (peopleMax+peoplemin)/2;
                //骑士加成
                float knighthurt=Float.parseFloat(knight2.getText());
                // 宝石
                float stonehurt=Float.parseFloat(attackStone2.getText());
                //暴击率
                float cirthurt=Float.parseFloat(crit2.getText());
                //技能系数
                float skillhurt=Float.parseFloat(skill2.getText());
                //暴击值
                float critVaulehurt=Float.parseFloat(critValue2.getText());
                //装备元素属性
                float  elementhurt=Float.parseFloat(element2.getText());
                value1.setText(""+peoplemin);
                //人物神圣伤害加成
                float godhurt=Float.parseFloat(godhurt2.getText());
                //幻兽神圣伤害
                float godbabyhurt=Float.parseFloat(babyhurt2.getText());
                //人物单次伤害
               float allhurt= peoplehurt*skillhurt*((1+stonehurt)*(1+knighthurt)+godhurt);
               //模拟100次人物平均伤害
               float averagehurt=(allhurt*(1-cirthurt)*100+allhurt*cirthurt*100*critVaulehurt)/100;
               value1.setText(""+allhurt);
               value2.setText(""+averagehurt);
               //a幻兽伤害
                float ababymin=Float.parseFloat(ababy2.getText());
                float ababymax=Float.parseFloat(ababy3.getText());
                float ababyhurt= ((ababymax-ababymin)/2+ababymin+ababymax)/2;
                //b幻兽伤害
                float bbabymin=Float.parseFloat(bbaby2.getText());
                float bbabymax=Float.parseFloat(bbaby3.getText());
                float bbabyhurt= ((bbabymax-bbabymin)/2+bbabymin+bbabymax)/2;
                //c幻兽伤害
                float cbabymin=Float.parseFloat(cbaby2.getText());
                float cbabymax=Float.parseFloat(cbaby3.getText());
                float cbabyhurt= ((cbabymax-cbabymin)/2+cbabymin+cbabymax)/2;
                float allbabyhurt= (float) ((ababyhurt+bbabyhurt+cbabyhurt)*skillhurt*((1+stonehurt)*1.5+godbabyhurt)*(1+elementhurt));
                //模拟100次的幻兽人物平均伤害
                float averagebabyhurt=(allbabyhurt*(1-cirthurt)*100+allbabyhurt*cirthurt*100*critVaulehurt)/100;
                 value3.setText(""+allbabyhurt);
                 value4.setText(""+averagebabyhurt);
            }
        });
    }
}


