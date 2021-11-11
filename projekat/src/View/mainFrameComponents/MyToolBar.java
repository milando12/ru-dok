package View.mainFrameComponents;

import View.MainFrame;

import javax.swing.*;
import java.awt.*;

public class MyToolBar extends JToolBar {
    public MyToolBar(final JFrame parent){

        super(SwingConstants.HORIZONTAL);

        setPreferredSize(new Dimension(50,40));
//        JButton newBT= new JButton(MainFrame.getInstance().getActionManager().getNewAction());
//        newBT.setToolTipText("New");
//
//        add(newBT);
//        addSeparator();
//
//        JButton infoBT= new JButton("Info");
//        infoBT.setToolTipText("Info");
//
//        add(infoBT);

        add(MainFrame.getInstance().getActionManager().getNewAction());
        addSeparator();

        add(MainFrame.getInstance().getActionManager().getRemoveAction());
        addSeparator();

        add(MainFrame.getInstance().getActionManager().getChangePresentation());
        addSeparator();

        add(MainFrame.getInstance().getActionManager().getInfoAction());

        setBackground(new Color(135,206,250));
    }
}
