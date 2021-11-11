package View.tree.controler;

import Controller.ActionManager;
import View.MainFrame;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

public class MyTreeSelectionListener implements TreeSelectionListener{
    @Override
    public void valueChanged(TreeSelectionEvent e) {
//        System.out.println(MainFrame.getInstance().getMyJTree().getLastSelectedPathComponent());
    }
}
