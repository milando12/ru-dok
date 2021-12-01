package View.tree.controler;

import Controller.ActionManager;
import Model.tree.Project;
import View.MainFrame;
import View.mainFrameComponents.WorkspacePanel.ProjectView;
import View.tree.model.MyTreeNode;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

public class MyTreeSelectionListener implements TreeSelectionListener{
    @Override
    public void valueChanged(TreeSelectionEvent e) {
//        System.out.println(MainFrame.getInstance().getMyJTree().getLastSelectedPathComponent());
        MyTreeNode treeNode= (MyTreeNode) MainFrame.getInstance().getMyJTree().getLastSelectedPathComponent();
        if (treeNode.getNode() instanceof Project){
            Project project= (Project) treeNode.getNode();
            MainFrame.getInstance().getStblRadnaSpP().setRightComponent(new ProjectView(project));
        }
    }
}
