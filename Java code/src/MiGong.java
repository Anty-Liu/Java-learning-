public class MiGong {
    public static void main(String[] args){
        // 创建一个二维数组表示迷宫
        int[][] map = new int[8][7];
        // 布置迷宫
        for (int i = 0;i < map.length;i++){
            for (int j = 0;j<map[i].length;j++){
                if (i == 0||i == map.length-1 )
                    map[i][j] = 1;
                else {
                    map[i][0] = 1;
                    map[i][map[i].length-1] = 1;
                }
            }
        }
        map[2][2] = 1;
        map[3][1] = 1;
        map[3][2] = 1;
        map[7][5] = 0;
        for (int i = 0; i < map.length;i++){
            for (int j = 0; j<map[i].length;j++){
                System.out.print(map[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println("findWay:=============================");
        T rat = new T();
        rat.findWay(map,1, 1);
        for (int i = 0; i < map.length;i++){
            for (int j = 0; j<map[i].length;j++){
                System.out.print(map[i][j] + "  ");
            }
            System.out.println();
        }
    }
}

class T {
    // 使用递归回溯的思想来解决老鼠出迷宫
// 1.findway方法，专门来找出迷宫路径的
// 2. 如果找到就返回true，否则返回false
// 3.map就是二维数组，表示迷宫
// 4.i,j就是老鼠的位置，初始化为（1，1）
// 5.因为我们是递归找路，所以我们先规定map数组各值的含义
// 0：表示可以走  1：表示障碍物  2：表示走过  3：表示走过，但是走不通是死路
//    当map[7][5] == 2时，表示已经找到路了
//    找路的策略为：下-右-左-上
    public boolean findWay(int[][] map, int i, int j) {
        if (map[7][5] == 2)
            return true;
        else {
            if(map[i][j] == 0) {
                map[i][j] = 2;
                if (findWay(map, i + 1, j))
                    return true;
                else if (findWay(map, i, j + 1))
                    return true;
                else if (findWay(map, i, j - 1))
                    return true;
                else if (findWay(map, i - 1, j))
                    return true;
                else {
                    map[i][j] = 3;
                    return false;
                }
            }
            else
                return false;
        }
    }
}



