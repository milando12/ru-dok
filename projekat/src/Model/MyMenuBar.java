package Model;

import javax.swing.*;

public class MyMenuBar extends JMenuBar {
    public MyMenuBar(){

        JMenu file= new JMenu("File");
        JMenu help= new JMenu("Help");
        JMenu edit= new JMenu("Edit");

        JMenuItem nov= new JMenuItem("New");

        file.add(nov);

        add(file);
        add(help);
        add(edit);
    }
}
