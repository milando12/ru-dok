package Controller;

import Controller.AbstractRudokAction;
import Model.tree.Prezentation;
import Model.tree.Project;
import Model.tree.Slide;
import Model.tree.Workspace;
import Model.tree.nodes.RuNode;
import Model.tree.nodes.RuNodeComposit;
import View.MainFrame;
import View.tree.model.MyTreeNode;
import View.tree.view.MyJTree;

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

        MyTreeNode parentTreeNod= (MyTreeNode) MainFrame.getInstance()
                .getMyJTree().getLastSelectedPathComponent();

        MainFrame.getInstance().getMyJTree().expandPath(MainFrame.getInstance().getMyJTree().getSelectionPath());
        if (parentTreeNod!=null){
            RuNode parent= parentTreeNod.getNode();
            if (parent instanceof Workspace){
                String ime= "Projekat "+(parentTreeNod.getChildCount()+1);
                Project project= new Project(ime,parent);
                MyTreeNode childTreeNode= new MyTreeNode(project);

                parentTreeNod.addChild(childTreeNode);
                childTreeNode.setParent(parentTreeNod);
            }else if (parent instanceof Project){
                String ime= "Prezentacija "+(parentTreeNod.getChildCount()+1);
                Prezentation prezentation= new Prezentation(ime,parent);
                MyTreeNode childTreeNode= new MyTreeNode(prezentation);

                parentTreeNod.addChild(childTreeNode);
                childTreeNode.setParent(parentTreeNod);
            }else if (parent instanceof Prezentation){
                String ime= "Slajd "+(parentTreeNod.getChildCount()+1);
                Slide slide= new Slide(ime,parent);
                MyTreeNode childTreeNode= new MyTreeNode(slide);

                parentTreeNod.addChild(childTreeNode);
                childTreeNode.setParent(parentTreeNod);
            }else {
                //TODO ne moze da doda u slajd
            }
        }else {
            //TODO selektuj nesto
        }
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyJTree());
        MainFrame.getInstance().getMyJTree().expandPath(MainFrame.getInstance()
                .getMyJTree().getSelectionPath());
    }
}
