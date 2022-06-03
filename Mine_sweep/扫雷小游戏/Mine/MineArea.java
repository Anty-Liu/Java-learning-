

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Stack;

public class MineArea extends JPanel implements ActionListener, MouseListener {
    JButton reStart;    //重新开始按钮
    Block[][] block;      //雷区的方块
    BlockView[][] blockView;    //方块的视图
    LayMines lay;     //负责布雷
    PeopleScoutMine peopleScoutMine;   //负责扫雷
    int row, column, mineCount, markMount;     //雷区的行数，雷叔以及地雷个数和用户给出的标记数
    String mark;    //探雷做的标记
    JPanel pCenter, pNorth;    //布局用的面板
    JTextField showTime, showMarkedMineCount;   //显示用时和探雷坐标的标记数目（不一定是雷）
    Timer time;         //计时器
    int spendTime = 0;    //扫雷的用时
    Inform inform;     //负责记录到英雄榜
    public MineArea(int row, int column, int mineCount) {
        inform = new Inform();
        reStart = new JButton("重新开始");
        mark = "☺"; //扫雷标记
        time = new Timer(1000, this);      //计时器，每隔一秒触发一次ActionEvent事件
        showTime = new JTextField(5);
        showMarkedMineCount = new JTextField(5);
        showMarkedMineCount.setEditable(false);          //设置显示雷余量的文本框不可编辑
        showTime.setHorizontalAlignment(JTextField.CENTER);
        showTime.setEditable(false);    //设置显示所用时间的文本框不可编辑
        showMarkedMineCount.setHorizontalAlignment(JTextField.CENTER);
        showMarkedMineCount.setFont(new Font("Arial", Font.BOLD, 16));
        showTime.setFont(new Font("Arial", Font.BOLD, 16));
        pCenter = new JPanel();
        pNorth = new JPanel();
        lay = new LayMines();   //创建布雷者
        peopleScoutMine = new PeopleScoutMine();    //创建扫雷者
        initMineArea(row, column, mineCount);   //初始化雷区，见下面的initMineArea()方法
        reStart.addActionListener(this);
        pNorth.add(new JLabel("剩余雷数"));
        pNorth.add(showMarkedMineCount);
        pNorth.add(reStart);
        pNorth.add(new JLabel("用时："));
        pNorth.add(showTime);
        setLayout(new BorderLayout());
        add(pNorth, BorderLayout.NORTH);
        add(pCenter, BorderLayout.CENTER);
    }
    //初始化雷区
    public void initMineArea(int row, int column, int mineCount) {
        pCenter.removeAll();
        spendTime = 0;
        markMount = mineCount;
        this.row = row;
        this.column = column;
        this.mineCount = mineCount;
        block = new Block[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++)
                block[i][j] = new Block();
        }
        lay.layMinesForBlock(block, mineCount);   //布雷
        peopleScoutMine.setBlock(block, mineCount);  //准备扫雷
        blockView = new BlockView[row][column];   //创建方块的视图
        pCenter.setLayout(new GridLayout(row, column));
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                blockView[i][j] = new BlockView();
                block[i][j].setBlockView(blockView[i][j]);  //方块设置自己的视图
                blockView[i][j].setDataOnView();  //将block[i][j]的数据放入视图
                pCenter.add(blockView[i][j]);
                blockView[i][j].getBlockCover().addActionListener(this);   //注册监听器
                blockView[i][j].getBlockCover().addMouseListener(this);
                blockView[i][j].seeBlockCover();     //初始时盖住block[i][j]的数据信息
                blockView[i][j].getBlockCover().setEnabled(true);
                blockView[i][j].getBlockCover().setIcon(null);
            }
        }
        showMarkedMineCount.setText("" + markMount);
        repaint();
    }



    public void actionPerformed(ActionEvent e) {
        if (e.getSource() != reStart && e.getSource() != time) {
            time.start();
            int m = -1, n = -1;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    if (e.getSource() == blockView[i][j].getBlockCover()) {
                        m = i;
                        n = j;
                        break;
                    }
                }
            }
            if (block[m][n].isMine()) {
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < column; j++) {
                        blockView[i][j].getBlockCover().setEnabled(false);
                        if (block[i][j].isMine())
                            blockView[i][j].seeBlockNameOrIcon();
                    }
                }
                time.stop();
                spendTime = 0;  //恢复初始值
                markMount = mineCount;  //恢复初始值
            } else {  //扫雷者得到的block[m][n]周围区域不是雷的方块
                Stack<Block> notMineBlock = peopleScoutMine.getNoMineAroundBlock(block[m][n]);
                while (!notMineBlock.empty()) {
                    Block bk = notMineBlock.pop();
                    ViewForBlock viewForBlock = bk.getBlockView();
                    viewForBlock.seeBlockNameOrIcon();   //视图显示方块上的数据信息
                    System.out.println("ok");
                }
            }
        }
        if (e.getSource() == reStart) {
            initMineArea(row, column, mineCount);
            repaint();
            validate();
        }
        if (e.getSource() == time) {
            spendTime++;
            showTime.setText("" + spendTime);
        }
        if (peopleScoutMine.verifyWin()) {   //判断用户是否扫雷成功
            time.stop();   //计时停止
            inform.setVisible(true);   //弹出挑战成功对话框
        }
    }

    public void mousePressed(MouseEvent e) {  //探雷：给方块上插一个小旗图标（再次右单击取消）
        JButton source = (JButton) e.getSource();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (e.getModifiersEx() == InputEvent.BUTTON3_DOWN_MASK && source == blockView[i][j].getBlockCover()) {
                    if (block[i][j].getIsMark()) {
                        source.setText(" ");
                        block[i][j].setIsMark(false);
                        markMount = markMount + 1;
                        showMarkedMineCount.setText("" + markMount);
                    } else {
                        source.setText(mark);
                        block[i][j].setIsMark(true);
                        markMount = markMount - 1;
                        showMarkedMineCount.setText("" + markMount);
                    }
                }
            }
        }
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }
}

