package Command;

import Factory.FactoryGenerator;
import Factory.NodeFactories.NodeFactory;
import Model.tree.Project;
import Model.tree.nodes.RuNode;
import Model.tree.nodes.RuNodeComposit;
import View.MainFrame;
import View.tree.model.MyTreeNode;

import javax.swing.*;

public class RemoveCommand extends AbstractCommand{
    private MyTreeNode selectedTreeNode;
    private RuNode ruNode;

    public RemoveCommand(MyTreeNode selectedTreeNode, RuNode ruNode) {
        this.selectedTreeNode = selectedTreeNode;
        this.ruNode = ruNode;
    }

    @Override
    public void doCommand() {
        ((MyTreeNode) selectedTreeNode.getParent()).removeChild(selectedTreeNode);
        ((RuNodeComposit)ruNode.getParent()).removeChild(ruNode);

        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyJTree());

        if (ruNode instanceof Project) MainFrame.getInstance()
                .getTreeRadnaSpP().setRightComponent(new JPanel());
    }

    @Override
    public void undoCommand() {
        ((MyTreeNode)selectedTreeNode.getParent()).addChild(selectedTreeNode);
        ((RuNodeComposit)ruNode.getParent()).addChild(ruNode);

        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyJTree());
        MainFrame.getInstance().getMyJTree().expandPath(MainFrame.getInstance()
                .getMyJTree().getSelectionPath());
    }
}
