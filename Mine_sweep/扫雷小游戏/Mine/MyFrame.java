

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JDialog implements ActionListener {
    JTextField row,column,mineCount;
    JLabel label1,label2,label3;
    JPanel panel1,panel2,panel3,panel4;
    JButton confirm,cancel;
    int m,n,k;

    MyFrame(){
        setLayout(new FlowLayout());
        row=new JTextField(5);
        column=new JTextField(5);
        mineCount=new JTextField(5);
        panel1=new JPanel();
        panel2=new JPanel();
        panel3=new JPanel();
        panel4=new JPanel();
        label1=new JLabel("请输入您想挑战的扫雷行数:");
        label2=new JLabel("请输入您想挑战的扫雷列数:");
        label3=new JLabel("请输入您想挑战的扫雷地雷的数目:");
        confirm=new JButton("开始");
        cancel=new JButton("取消");
        panel1.add(label1);
        panel1.add(row);
        panel2.add(label2);
        panel2.add(column);
        panel3.add(label3);
        panel3.add(mineCount);
        panel4.add(confirm);
        panel4.add(cancel);
        add(panel1);
        add(panel2);
        add(panel3);
        add(panel4);
        confirm.addActionListener(this);
        cancel.addActionListener(this);

    }
    public void actionPerformed(ActionEvent e) {
  if(e.getSource()==confirm){
      try{
          m=Integer.parseInt(row.getText());
          n=Integer.parseInt(column.getText());
          k=Integer.parseInt(mineCount.getText());
          new CustomListener(m,n,k);
          dispose();
          CustomListener window4 =new CustomListener(m,n,k);
          window4.setBounds(50,0,1150,700);
          window4.setTitle("自定义模式");
          window4.setVisible(true);
      }
      catch (Exception exp){
      }

  }
  if(e.getSource()==cancel){
      dispose();
      MainPage mainPage=new MainPage();
      mainPage.setBounds(200,40,800,600);
      mainPage.setTitle("扫雷");
      Container container=mainPage.getContentPane();
      container.setBackground(Color.darkGray);
      mainPage.getMainPage(mainPage);
  }
    }

}