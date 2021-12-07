package View.tree.controler;

import Model.tree.Prezentation;
import Model.tree.Project;
import Model.tree.Slide;
import Model.tree.Workspace;
import View.MainFrame;
import View.tree.model.MyTreeNode;
import Error.*;

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

        if (component instanceof MyTreeNode && e.getActionCommand().toString().length()>0){
            if (((MyTreeNode)component).getNode() instanceof Project)
                ((Project)((MyTreeNode)component).getNode()).changeName(e.getActionCommand());
            else if (((MyTreeNode)component).getNode() instanceof Prezentation)
                ((Prezentation) ((MyTreeNode)component).getNode()).changeName(e.getActionCommand());
            else
            ((MyTreeNode)component).getNode().setName(e.getActionCommand());
        }else ErrorFactory.getInstance().generateError("Ne mozete ostaviti prazno ime cvora"
        , 2, "Upozorenje");
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
