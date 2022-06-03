

import javax.swing.*;

public class Block {
    String name;   //”雷“的名字或者数字
    int aroundMineNumber;   //显示周围雷的数目
    public boolean isMine = false;    //是否为雷
    boolean isMark = false;    //是否被标记
    boolean isOpen = false;    //是否被挖开
    ViewForBlock blockView;    //方块视图

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAroundMineNumber(int n) {
        aroundMineNumber = n;
    }

    public int getAroundMineNumber() {
        return aroundMineNumber;
    }

    public boolean isMine() {
        return isMine;
    }

    public void setIsMine(boolean b) {
        isMine = b;
    }

    public void setIsOpen(boolean p) {
        isOpen = p;
    }

    public boolean getIsOpen() {
        return isOpen;
    }

    public void setIsMark(boolean m) {
        isMark = m;
    }

    public boolean getIsMark() {
        return isMark;
    }

    public void setBlockView(ViewForBlock view) {
        blockView = view;
        blockView.acceptBlock(this);
    }

    public ViewForBlock getBlockView() {
        return blockView;
    }
}
