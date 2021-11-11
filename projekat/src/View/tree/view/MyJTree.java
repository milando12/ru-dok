package View.tree.view;

import Observer.ISubscriber;
import View.tree.controler.MyTreeCellEditor;
import View.tree.controler.MyTreeCellRenderer;
import View.tree.controler.MyTreeSelectionListener;
import View.tree.model.MyTreeNode;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;

public class MyJTree extends JTree implements ISubscriber {

    private MyTreeNode myTreeNode;

    public MyJTree(){
        addTreeSelectionListener(new MyTreeSelectionListener());
        setCellEditor(new MyTreeCellEditor(this, new DefaultTreeCellRenderer()));
        setCellRenderer(new MyTreeCellRenderer());
        setEditable(true);
    }

    @Override
    public void update(Object nortification) {

    }
}
