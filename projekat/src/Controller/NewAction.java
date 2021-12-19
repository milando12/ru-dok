package Controller;

import Controller.AbstractRudokAction;
import Factory.FactoryGenerator;
import Factory.NodeFactories.NodeFactory;
import Model.tree.Prezentation;
import Model.tree.Project;
import Model.tree.Slide;
import Model.tree.Workspace;
import Model.tree.nodes.RuNode;
import Model.tree.nodes.RuNodeComposit;
import View.MainFrame;
import View.tree.model.MyTreeNode;
import View.tree.view.MyJTree;
import Error.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class NewAction extends AbstractRudokAction {

    public NewAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
        putValue(SMALL_ICON, loadIcon("slike/new.png"));
        putValue(NAME, "New");
        putValue(SHORT_DESCRIPTION, "New");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        MyTreeNode selectedTreeNode= (MyTreeNode) MainFrame.getInstance()
                .getMyJTree().getLastSelectedPathComponent();

        MainFrame.getInstance().getMyJTree().expandPath(MainFrame.getInstance().getMyJTree().getSelectionPath());
        if (selectedTreeNode!=null){
            RuNode parent= selectedTreeNode.getNode();

            if (parent instanceof Slide){
                ErrorFactory.getInstance().generateError("Ne postoji stuktura niza od slajda"
                        , 2, "Upozorenje");
            }else {
                NodeFactory nodeFactory= FactoryGenerator.returnNodeFactroy(selectedTreeNode);
                MyTreeNode child= nodeFactory.makeTreeNode(selectedTreeNode);

                selectedTreeNode.addChild(child);
                child.setParent(selectedTreeNode);
            }

        }else {
            ErrorFactory.getInstance().generateError("Selektuj neki cvor"
                    , 1, "");
        }
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyJTree());
        MainFrame.getInstance().getMyJTree().expandPath(MainFrame.getInstance()
                .getMyJTree().getSelectionPath());
    }
}
