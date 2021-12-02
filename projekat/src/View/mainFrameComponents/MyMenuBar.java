package View.mainFrameComponents;

import View.MainFrame;

import javax.swing.*;
import java.awt.*;

public class MyMenuBar extends JMenuBar {
    public MyMenuBar(){
        setBackground(new Color(0));

        JMenu file= new JMenu("File");
        JMenu help= new JMenu("Help");
        JMenu edit= new JMenu("Edit");

        file.add(MainFrame.getInstance().getActionManager().getNewAction());

        add(file);
        add(help);
        add(edit);

    }
}
