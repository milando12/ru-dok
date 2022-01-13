package Controller.EditPresentation;

import Model.tree.Prezentation;
import View.Dialogs.EditPresentationDialog;
import View.MainFrame;
import View.tree.model.MyTreeNode;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeThemeAction implements ActionListener {

    private EditPresentationDialog parent;
    public ChangeThemeAction(EditPresentationDialog parent){
        this.parent= parent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (parent.getSlikaTF().getText() != null && MainFrame.getInstance().getMyJTree().getLastSelectedPathComponent() instanceof MyTreeNode){
            Prezentation prezentation= (Prezentation) ((MyTreeNode) MainFrame.getInstance().getMyJTree()
                    .getLastSelectedPathComponent()).getNode();
            prezentation.changeTheme(parent.getSlikaTF().getText());
        }
    }
}
