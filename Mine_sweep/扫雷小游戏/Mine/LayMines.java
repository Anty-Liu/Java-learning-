

import java.util.LinkedList;

public class LayMines {
    //初始化雷区
    public void initBlock(Block[][] block) {
        for (int i = 0; i < block.length; i++) {
            for (int j = 0; j < block[i].length; j++)
                block[i][j].setIsMine(false);
        }
    }

    public void layMinesForBlock(Block[][] block, int mineCount) {
                                              // 在布雷区设置mineCount个雷
        initBlock(block);                    //将全部方块设置成不是雷
        int row = block.length;
        int column = block[0].length;
        LinkedList<Block> list = new LinkedList<Block>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                list.add(block[i][j]);
            }
        }
        while (mineCount > 0) {
            int size = list.size();                             //开始布雷
            int randomIndex = (int) (Math.random() * size);     //list返回节点的个数
            Block b = list.get(randomIndex);
            b.setIsMine(true);                                  //设置方块是雷
            b.setName("☹");                                    //设置雷的图标
            list.remove(randomIndex);                           //list删除索引值为randomIndex的节点
            mineCount--;
        }

        for (int i = 0; i < row; i++) {                         //检查布雷的情况，标记每个方块周围雷的数目
            for (int j = 0; j < column; j++) {
                if (block[i][j].isMine) {
                    block[i][j].setIsOpen(false);
                    block[i][j].setIsMark(false);
                } else {
                    int mineNumber = 0;
                    for (int k = Math.max(i - 1, 0); k <= Math.min(i + 1, row - 1); k++) {
                        for (int t = Math.max(j - 1, 0); t <= Math.min(j + 1, column - 1); t++) {
                            if (block[k][t].isMine())
                                mineNumber++;
                        }
                    }
                    block[i][j].setIsOpen(false);
                    block[i][j].setIsMark(false);
                    block[i][j].setName("" + mineNumber);
                    block[i][j].setAroundMineNumber(mineNumber);     //设置该方块周围雷的数目
                }
            }
        }
    }
}
