package Controller.EditPresentation;

import Model.tree.Prezentation;
import View.EditPresentationDialog;
import View.MainFrame;
import View.tree.model.MyTreeNode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeAuthorAction implements ActionListener {

    private EditPresentationDialog parent;

    public ChangeAuthorAction(EditPresentationDialog parent){
        this.parent= parent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (parent.getAutorTF().getText()!= null){
            if (MainFrame.getInstance().getMyJTree().getLastSelectedPathComponent() instanceof MyTreeNode){
                Prezentation prezentation= (Prezentation) ((MyTreeNode) MainFrame.getInstance().getMyJTree()
                        .getLastSelectedPathComponent()).getNode();
                prezentation.setAuthor(parent.getAutorTF().getText());
            }
        }
    }
}
