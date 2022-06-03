

import javax.swing.*;
import java.awt.*;

public class BlockView extends JPanel implements ViewForBlock {
    JLabel blockNameOrIcon;  //用来显示block对象的name、number和mineIcon属性值
    JButton blockCover;   //用来遮挡blockNameOrIcon
    CardLayout card;   //卡片式布局
    Block block;

    BlockView() {
        card = new CardLayout();
        setLayout(card);
        blockNameOrIcon = new JLabel("", JLabel.CENTER);
        blockNameOrIcon.setHorizontalTextPosition(AbstractButton.CENTER);
        blockNameOrIcon.setVerticalTextPosition(AbstractButton.CENTER);
        blockCover = new JButton();
        add("cover", blockCover);
        add("view", blockNameOrIcon);
    }

    public void acceptBlock(Block block) {
        this.block = block;
    }

    public void setDataOnView() {
        if (block.isMine()) {
            blockNameOrIcon.setText(block.getName());    //如果是雷就得到雷的名字
        } else {
            int n = block.getAroundMineNumber();     //如果不是雷
            if (n >= 1)
                blockNameOrIcon.setText("" + n);       //周围有雷就存入周围雷的数目在该雷块中
            else blockNameOrIcon.setText(" ");          //周围没有雷，就存空值入雷块
        }
    }

    public void seeBlockNameOrIcon() {
        card.show(this, "view");
        validate();
    }

    public void seeBlockCover() {
        card.show(this, "cover");
        validate();
    }

    public JButton getBlockCover() {
        return blockCover;
    }
}
