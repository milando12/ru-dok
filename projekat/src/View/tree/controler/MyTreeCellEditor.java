package View.tree.controler;

import Model.tree.Prezentation;
import Model.tree.Project;
import Model.tree.Slide;
import Model.tree.Workspace;
import View.MainFrame;
import View.tree.model.MyTreeNode;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

public class MyTreeCellEditor extends DefaultTreeCellEditor implements ActionListener {

    private Object component= null;
    private JTextField edit= null;

    public MyTreeCellEditor(JTree tree, DefaultTreeCellRenderer renderer) {
        super(tree, renderer);
    }

    @Override
    public boolean isCellEditable(EventObject event) {
        if (event instanceof MouseEvent)
            if (((MouseEvent)event).getClickCount()==3){
                return true;
            }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        if ( component instanceof Project){
//            ((Project)component).setName(e.getActionCommand());
//        }else if ( component instanceof Prezentation){
//            ((Prezentation)component).setName(e.getActionCommand());
//        }else if (component instanceof Slide){
//            ((Slide)component).setName(e.getActionCommand());
//        }else if ( component instanceof Workspace){
//            ((Workspace)component).setName(e.getActionCommand());
//        }
        if (component instanceof MyTreeNode){
//            System.out.println(((MyTreeNode)MainFrame.getInstance().getMyJTree().getLastSelectedPathComponent()
//            ).getNode().getName());
            if (((MyTreeNode)component).getNode() instanceof Project) ((Project) ((MyTreeNode)component).getNode()).changeName(e.getActionCommand());
            else if (((MyTreeNode)component).getNode() instanceof Prezentation)
                ((Prezentation) ((MyTreeNode)component).getNode()).changeName(e.getActionCommand());
            else
            ((MyTreeNode)component).getNode().setName(e.getActionCommand());
//            System.out.println(((MyTreeNode)MainFrame.getInstance().getMyJTree().getLastSelectedPathComponent()
//                    ).getNode().getName());
        }
    }

    @Override
    public Component getTreeCellEditorComponent(JTree tree, Object value, boolean isSelected
            , boolean expanded, boolean leaf, int row) {
        component= value;

        edit=new JTextField(value.toString());
        edit.addActionListener(this);
        return edit;
    }
}
