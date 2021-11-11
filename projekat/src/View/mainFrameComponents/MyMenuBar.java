package View.mainFrameComponents;

import View.MainFrame;

import javax.swing.*;

public class MyMenuBar extends JMenuBar {
    public MyMenuBar(){

        JMenu file= new JMenu("File");
        JMenu help= new JMenu("Help");
        JMenu edit= new JMenu("Edit");

        file.add(MainFrame.getInstance().getActionManager().getNewAction());

        add(file);
        add(help);
        add(edit);
    }
}
