
import java.awt.*;

public class Mine {
    public static void main(String args[]){
        //设置主页面窗口
        MainPage mainPage=new MainPage();
        mainPage.setBounds(200,40,800,600);
        mainPage.setTitle("扫雷");
        Container container=mainPage.getContentPane();
        container.setBackground(Color.darkGray);
        mainPage.getMainPage(mainPage);
    }
}
