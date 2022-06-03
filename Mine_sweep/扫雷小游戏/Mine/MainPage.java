

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage extends JFrame {    //主页面窗口
    MainPage mainPage;
    JButton model1,model2,model3,model4; //四个模式的按钮
    //设置存放扫雷小游戏标签的面板
    JPanel jPanel=new JPanel();
    //设置存放四个模式按钮的面板
    JPanel p1=new JPanel();
    JPanel p2=new JPanel();
    JPanel p3=new JPanel();
    JPanel p4=new JPanel();
    JLabel bg;    //主页面扫雷小游戏的标签
    public void getMainPage(MainPage page) {
        this.mainPage = page;
    }
    public MainPage(){
        Init();
        ButtonStyle();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        validate();
    }
    public void Init(){
        //设置窗口布局为BorderLayout布局
        setLayout(new BorderLayout());
        //设置标题
        bg=new JLabel("扫雷小游戏",JLabel.CENTER);
        bg.setFont(new  Font("宋体",  Font.BOLD,  60));
        bg.setForeground(Color.black);
        //设置按钮名称
        model1=new JButton("简单9*9");
        model2=new JButton("中等16*16");
        model3=new JButton("困难15*25");
        model4=new JButton("自定义模式");
        //运用匿名类给按钮注册监听器
        model1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainPage.dispose();  //在开启下一个页面时关闭现在的窗口
                SimpleListener window1=new SimpleListener();
                window1.setBounds(350,100,500,500);
                window1.setTitle("简单模式");
                window1.setVisible(true);
            }
        });
        //运用匿名类给按钮注册监听器
        model2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainPage.dispose();   //在开启下一个页面时关闭现在的窗口
                MediumListener window2=new MediumListener();
                window2.setBounds(250,25,750,650);
                window2.setTitle("中等模式");
                window2.setVisible(true);
            }
        });
        //运用匿名类给按钮注册监听器
        model3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainPage.dispose();   //在开启下一个页面时关闭现在的窗口
                DifficultListener window3 =new DifficultListener();
                window3.setBounds(25,5,1200,680);
                window3.setTitle("困难模式");
                window3.setVisible(true);
            }
        });
        //运用匿名类给按钮注册监听器
        model4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainPage.dispose();  //在开启下一个页面时关闭现在的窗口
                MyFrame input =new MyFrame();
                input.setBounds(500,200,300,200);
                input.setTitle("自定义模式对话框");
                input.setVisible(true);
            }
        });
        //设置主页面按钮大小
        model1.setPreferredSize(new Dimension(350,70));
        model2.setPreferredSize(new Dimension(350,70));
        model3.setPreferredSize(new Dimension(350,70));
        model4.setPreferredSize(new Dimension(300,50));
        //向主版面窗口添加按钮
        add(bg,BorderLayout.CENTER);
        p1.add(model1);
        p2.add(model2);
        p3.add(model3);
        p4.add(model4);
        //设置jPanel为四行一列的GridLayout布局
        jPanel.setLayout(new GridLayout(4,1,50,30));
        jPanel.add(p1);
        jPanel.add(p2);
        jPanel.add(p3);
        jPanel.add(p4);
        add(jPanel,BorderLayout.SOUTH);
        //设置组件背景颜色
        jPanel.setBackground(Color.darkGray);
        p1.setBackground(Color.darkGray);
        p2.setBackground(Color.darkGray);
        p3.setBackground(Color.darkGray);
        p4.setBackground(Color.darkGray);
    }
    //设置按钮样式
    public void ButtonStyle(){
      model1.setBackground(Color.green);
      model2.setBackground(Color.orange);
      model3.setBackground(Color.red);
      model4.setBackground(Color.pink);
      model1.setBorderPainted(false);
      model2.setBorderPainted(false);
      model3.setBorderPainted(false);
      model4.setBorderPainted(false);
      model1.setFocusPainted(false);
      model2.setFocusPainted(false);
      model3.setFocusPainted(false);
      model4.setFocusPainted(false);
      model1.setFont(new  Font("宋体", Font.BOLD,  25));
      model2.setFont(new  Font("宋体",  Font.BOLD,  25));
      model3.setFont(new  Font("宋体",  Font.BOLD,  25));
      model4.setFont(new  Font("宋体",  Font.BOLD,  25));
    }
}
