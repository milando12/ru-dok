package Controller.EditPresentation;

import Model.tree.Prezentation;
import View.EditPresentationDialog;
import View.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeThemeAction implements ActionListener {

    private EditPresentationDialog parent;
    public ChangeThemeAction(EditPresentationDialog parent){
        this.parent= parent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (MainFrame.getInstance().getMyJTree().getLastSelectedPathComponent()
                instanceof Prezentation){
            ((Prezentation) MainFrame.getInstance().getMyJTree().getLastSelectedPathComponent())
                    .changeBackgroundImage(parent.getSlikaTF().getText());
        }
    }
}
