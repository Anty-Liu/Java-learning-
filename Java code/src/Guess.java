import java.util.Random;
import java.util.Scanner;

//石头见到布游戏
//0：石头  1：剪刀  2：布
public class Guess {
    public static void main(String[] args){
        int count = 0;
        String []  guess = {"石头", "剪刀", "布"};
        System.out.println("石头剪刀布游戏开始！");
        System.out.println("0：石头  1：剪刀  2：布");
        for (int i = 0; i < 3; i++){
            System.out.println("第" + (i+1) + "局");
            Computer computer = new Computer();
            Player player = new Player();
            int num1 = player.play();
            int num2 = computer.play();
            System.out.println("玩家：" + guess[num1] + "\t电脑：" + guess[num2]);
            if (num1 == num2){
                System.out.println("平局！");
            }
            else if (num1 == 0 && num2 == 2)
                System.out.println("电脑胜！");
            else if (num1 == 1 && num2 == 0)
                System.out.println("电脑胜！");
            else if (num1 == 2 && num2 == 1)
                System.out.println("电脑胜！");
            else{
                System.out.println("玩家胜！");
                count++;
            }
        }
        System.out.println("玩家赢了：" + count + "局");
    }
}

class Player{
    int num1;
    public int play(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.print("请玩家输入一个数：");
            this.num1 = scanner.nextInt();
            if (this.num1 > 2 || this.num1 < 0){
                System.out.println("输入有误（0，1，2），请重新输入！");
            }
            else
                return this.num1;
        }
    }
}

class Computer{
    int num2;
    public int play(){
        Random random = new Random();
        this.num2 = random.nextInt(3);
        return this.num2;
    }
}
