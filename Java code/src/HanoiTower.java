public class HanoiTower {
    public static void main (String[] args){
        Tower tower = new Tower();
        tower.move(3,  'A', 'B', 'C');
    }
}

class Tower{
    public void move(int num, char a, char b, char c){
        if (num == 1)
            System.out.println(a +"->"+ c);
        else {
//            如果num不为1，那么就借助c柱将num-1个盘子移动到b柱
            move(num - 1, a, c, b);
            System.out.println(a + "->" + c);
//            然后再借助a柱子将num-1个盘子移动到c柱
            move(num - 1, b, a, c);
        }
    }
}