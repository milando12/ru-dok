package Controller;

import Model.tree.Project;
import Model.tree.Workspace;
import Model.tree.nodes.RuNode;
import Model.tree.nodes.RuNodeComposit;
import View.MainFrame;
import View.tree.model.MyTreeNode;

import javax.swing.*;
import java.awt.*;
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
            MyTreeNode selectedNode= (MyTreeNode) MainFrame.getInstance().getMyJTree().getLastSelectedPathComponent();
            RuNode ruNode= selectedNode.getNode();
            ((MyTreeNode)selectedNode.getParent()).removeChild(selectedNode);
            ((RuNodeComposit)ruNode.getParent()).removeChild(ruNode);

            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyJTree());

            if (ruNode instanceof Project) MainFrame.getInstance().getStblRadnaSpP().setRightComponent(new JPanel());
        }else {
            //TODO selektuj cvor koji brises, tj bar neki cvor
        }
    }
}
