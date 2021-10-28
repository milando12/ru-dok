package Model;

import javax.swing.*;
import java.awt.*;

public class MyToolBar extends JToolBar {
    public MyToolBar(){

        super(SwingConstants.HORIZONTAL);

        JButton newBT= new JButton("New");
        newBT.setToolTipText("New");

        add(newBT);
        addSeparator();

        JButton infoBT= new JButton("Info");
        infoBT.setToolTipText("Info");

        add(infoBT);

        setBackground(new Color(135,206,250));
    }

}
