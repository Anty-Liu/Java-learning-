

public interface ViewForBlock {
     void acceptBlock(Block block);  //确定那个方块提供视图
     void setDataOnView();           //设置视图上需要显示的数据
     void seeBlockNameOrIcon();      //显示方块是上的名字或图标
     void seeBlockCover();           //显示视图上的遮挡组件
     Object getBlockCover();         //得到视图上的遮挡组件
}
