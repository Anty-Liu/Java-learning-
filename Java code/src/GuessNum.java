import java.util.Random;
import java.util.Scanner;

public class GuessNum {
    public static void main(String[] args){
        System.out.println("开始猜数字！！");
//        随机产生一个数字
        Random random = new Random();
        int num = random.nextInt(10);
        while(true){
            System.out.print("请输入一个0~9之间的数字：");
            Scanner scanner = new Scanner(System.in);
            int i = scanner.nextInt();
            if (num == i){
                System.out.println("恭喜你，猜对啦！！");
                break;
            }
            else
                System.out.println("猜错啦！！");
        }
    }
}
