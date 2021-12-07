package Controller.EditPresentation;

import Controller.AbstractRudokAction;
import Model.tree.Prezentation;
import View.EditPresentationDialog;
import View.MainFrame;
import View.tree.model.MyTreeNode;
import Error.*;
import com.sun.tools.javac.Main;

import java.awt.event.ActionEvent;

public class ChangePresentationAction extends AbstractRudokAction {

    public ChangePresentationAction(){
        putValue(SMALL_ICON, loadIcon("write.png"));
        putValue(NAME, "Edit Presentaton");
        putValue(SHORT_DESCRIPTION, "Edit Presentation");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (MainFrame.getInstance().getMyJTree().getLastSelectedPathComponent() instanceof MyTreeNode){
            MyTreeNode selectedComponent= (MyTreeNode) MainFrame.getInstance().getMyJTree().getLastSelectedPathComponent();
            if (selectedComponent.getNode() instanceof Prezentation){
                EditPresentationDialog editPresentationDialog= new EditPresentationDialog
                        (MainFrame.getInstance());
                editPresentationDialog.setVisible(true);
            }else {
                ErrorFactory.getInstance().generateError("Ovo dugme sluzi samo za edit prezentacije."
                        , 1, "Informacija");
            }
        }
    }
}
