package Controller;

import Model.tree.Workspace;
import View.MainFrame;
import View.tree.model.MyTreeNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class RemoveAction extends AbstractRudokAction{
    public RemoveAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_DOWN_MASK));
        putValue(SMALL_ICON, loadIcon("slike/bin.png"));
        putValue(NAME, "Remove");
        putValue(SHORT_DESCRIPTION, "Remove");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (MainFrame.getInstance().getMyJTree().getLastSelectedPathComponent()instanceof MyTreeNode
                && !(((MyTreeNode)MainFrame.getInstance().getMyJTree().getLastSelectedPathComponent()).getNode()
                instanceof Workspace)){
            System.out.println("Usao u if");
            MyTreeNode selectedNode= (MyTreeNode) MainFrame.getInstance().getMyJTree().getLastSelectedPathComponent();
            ((MyTreeNode)selectedNode.getParent()).removeChild(selectedNode);

            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyJTree());
        }else {
            //TODO selektuj cvor koji brises, tj bar neki cvor
        }
    }
}
