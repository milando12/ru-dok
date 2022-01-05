package Controller;

import Command.RemoveCommand;
import Model.tree.Project;
import Model.tree.Workspace;
import Model.tree.nodes.RuNode;
import Model.tree.nodes.RuNodeComposit;
import View.MainFrame;
import View.tree.model.MyTreeNode;
import Error.ErrorFactory;

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
                && !(((MyTreeNode)MainFrame.getInstance().getMyJTree().getLastSelectedPathComponent())
                .getNode() instanceof Workspace)){
            MyTreeNode selectedNode= (MyTreeNode) MainFrame.getInstance().getMyJTree().getLastSelectedPathComponent();
            RuNode ruNode= selectedNode.getNode();

            MainFrame.getInstance().getCommandManager()
                    .addCommand(new RemoveCommand(selectedNode, ruNode));

        }else {
            ErrorFactory.getInstance().generateError("Slektuj cvor koji nije RadnaPovrsina"
            , 2, "Ne moze se brisati Radna Povrsina");
        }
    }
}
