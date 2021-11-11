package Controller;

import Model.tree.Prezentation;
import View.EditPresentationDialog;
import View.MainFrame;
import View.tree.model.MyTreeNode;
import com.sun.tools.javac.Main;

import java.awt.event.ActionEvent;

public class ChangePresentationAction extends AbstractRudokAction{

    public ChangePresentationAction(){
        putValue(SMALL_ICON, loadIcon("slike/write.png"));
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
                //TODO error mora da bude selektovana prezentacija da bi editovao
            }
        }
    }
}
