

import java.util.Stack;

public class PeopleScoutMine {
    public Block[][] block;       //雷区的全部方块
    Stack<Block> notMineBlock;    //存放一个方块周围区域内不是雷的方块
    int m, n;                     //方块的索引下标
    int row, column;              //雷区的行和列
    int mineCount;                //雷的数目

    public PeopleScoutMine() {
        notMineBlock = new Stack<Block>();
    }

    public void setBlock(Block[][] block, int mineCount) {
        this.block = block;
        this.mineCount = mineCount;
        row = block.length;
        column = block[0].length;
    }

    //得到方块bk的附近区域不是雷的方块
    public Stack<Block> getNoMineAroundBlock(Block bk) {
        notMineBlock.clear();
        //寻找bk在雷区block中的位置的索引
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (bk == block[i][j]) {
                    m = i;
                    n = j;
                    break;
                }
            }
        }
        //方块不是雷
        if (!bk.isMine()) {
            //见后面的递归方法
            show(m, n);
        }
        return notMineBlock;
    }

    public void show(int m, int n) {
        if (block[m][n].getAroundMineNumber() > 0 && !block[m][n].getIsOpen()) {
            block[m][n].setIsOpen(true);
            //将不是雷的方块压推栈
            notMineBlock.push(block[m][n]);
        } else if (block[m][n].getAroundMineNumber() == 0 && !block[m][n].getIsOpen()) {
            block[m][n].setIsOpen(true);
            //将不是雷的方块压推栈
            notMineBlock.push(block[m][n]);
            for (int k = Math.max(m - 1, 0); k <= Math.min(m + 1, row - 1); k++) {
                for (int t = Math.max(n - 1, 0); t <= Math.min(n + 1, column - 1); t++)
                    show(k, t);
            }
        }
    }

    public boolean verifyWin() {
        boolean isOK = false;
        int number = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (!block[i][j].getIsOpen())
                    number++;
            }
        }
        if (number == mineCount) {
            isOK = true;
        }
        return isOK;
    }
}
