

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inform extends JDialog implements ActionListener {
    JLabel label;
    JButton confirm;
    public Inform() {
        setTitle("挑战成功");
        setBounds(500, 200, 250, 150);
        setResizable(false);
        setModal(true);
        confirm = new JButton("确定");
        confirm.setFocusPainted(false);
        confirm.addActionListener(this);
        setLayout(new java.awt.GridLayout(2, 1));
        label = new JLabel("   恭喜你，挑战成功！！");
        add(label);
        JPanel p = new JPanel();
        p.add(confirm);
        add(p);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }


    public void actionPerformed(ActionEvent e) {
        this.dispose();
        MainPage mainPage=new MainPage();
        mainPage.setBounds(200,40,800,600);
        mainPage.setTitle("扫雷");
        Container container=mainPage.getContentPane();
        container.setBackground(Color.darkGray);
        mainPage.getMainPage(mainPage);
    }
}