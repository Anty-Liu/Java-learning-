

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomListener extends JFrame implements ActionListener {
    JButton back;    //返回主页面按钮
    MineArea mineArea;   //扫雷区域
    int m,n,k;  //自定义的雷区行数、列数和雷的个数
    public CustomListener(int m,int n,int k) {
        back=new JButton("返回主页");
        back.setFocusPainted(false);
        this.m=m;
        this.n=n;
        this.k=k;
        mineArea = new MineArea(m, n, k);
        back.addActionListener(this);   //给返回主页面按钮注册监听器
        mineArea.pNorth.add(back);
        add(mineArea, BorderLayout.CENTER);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        validate();
    }
    //按下主菜单按钮能够关闭本窗口，并返回主页面
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
