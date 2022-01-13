package Command;

import Factory.FactoryGenerator;
import Factory.NodeFactories.NodeFactory;
import Model.tree.Project;
import Model.tree.nodes.RuNode;
import Model.tree.nodes.RuNodeComposit;
import View.MainFrame;
import View.tree.model.MyTreeNode;

import javax.swing.*;

public class NewCommand extends AbstractCommand{
    private MyTreeNode selectedTreeNode;
    private RuNode ruNode;
    private MyTreeNode child;

    public NewCommand(MyTreeNode selectedTreeNode, RuNode parent) {
        this.selectedTreeNode = selectedTreeNode;
        this.ruNode = parent;
    }

    @Override
    public void doCommand() {
        if( child== null){
            NodeFactory nodeFactory= FactoryGenerator.returnNodeFactroy(selectedTreeNode);
            child= nodeFactory.makeTreeNode(selectedTreeNode);
        }

        selectedTreeNode.addChild(child);
        child.setParent(selectedTreeNode);


        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyJTree());
        MainFrame.getInstance().getMyJTree().expandPath(MainFrame.getInstance()
                .getMyJTree().getSelectionPath());
    }

    @Override
    public void undoCommand() {
        ((MyTreeNode) child.getParent()).removeChild(child);
        ((RuNodeComposit)(child.getNode()).getParent()).removeChild(child.getNode());

        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyJTree());

        if (child.getNode() instanceof Project) MainFrame.getInstance()
                .getTreeRadnaSpP().setRightComponent(new JPanel());
    }
}
