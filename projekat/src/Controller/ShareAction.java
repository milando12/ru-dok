package Controller;

import Model.tree.Prezentation;
import View.MainFrame;
import View.Dialogs.SharePresentationDialog;
import View.tree.model.MyTreeNode;

import java.awt.event.ActionEvent;
import Error.*;

public class ShareAction extends AbstractRudokAction {

    public ShareAction() {
        putValue(SMALL_ICON, loadIcon("slike/share.png"));
        putValue(NAME, "Share");
        putValue(SHORT_DESCRIPTION, "Share Prezentation");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (MainFrame.getInstance().getMyJTree().getLastSelectedPathComponent() instanceof MyTreeNode){
            MyTreeNode selectedComponent= (MyTreeNode) MainFrame.getInstance().getMyJTree().getLastSelectedPathComponent();
            if (selectedComponent.getNode() instanceof Prezentation){
                SharePresentationDialog sharePresentationDialog= new SharePresentationDialog
                        (MainFrame.getInstance());
                sharePresentationDialog.setVisible(true);
            }else {
                ErrorFactory.getInstance().generateError("Ovo dugme sluzi samo za deljenje prezentacije."
                        , 1, "Informacija");
            }
        }
    }
}
