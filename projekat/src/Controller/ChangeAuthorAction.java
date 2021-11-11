package Controller;

import Model.tree.Prezentation;
import View.EditPresentationDialog;
import View.MainFrame;

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
        if (MainFrame.getInstance().getMyJTree().getLastSelectedPathComponent()
                instanceof Prezentation){
            ((Prezentation) MainFrame.getInstance().getMyJTree().getLastSelectedPathComponent())
                    .changeAuthor(parent.getAutorTF().getText());
        }
    }
}
