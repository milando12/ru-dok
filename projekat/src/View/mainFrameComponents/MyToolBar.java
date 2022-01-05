package View.mainFrameComponents;

import View.MainFrame;

import javax.swing.*;
import java.awt.*;

public class MyToolBar extends JToolBar {
    public MyToolBar(final JFrame parent){

        super(SwingConstants.HORIZONTAL);

        setPreferredSize(new Dimension(50,40));

        add(MainFrame.getInstance().getActionManager().getNewAction());
        addSeparator();

        add(MainFrame.getInstance().getActionManager().getRemoveAction());
        addSeparator();

        add(MainFrame.getInstance().getActionManager().getChangePresentation());
        addSeparator();

        add(MainFrame.getInstance().getActionManager().getUndoAction());
        addSeparator();

        add(MainFrame.getInstance().getActionManager().getRedoAction());
        MainFrame.getInstance().getActionManager().getRedoAction().setEnabled(false);
        addSeparator();

        add(MainFrame.getInstance().getActionManager().getInfoAction());

    }
}
