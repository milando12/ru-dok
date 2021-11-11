package View.tree.model;

import Model.tree.Workspace;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

public class MyModel extends DefaultTreeModel {

    public MyModel() {
        super(new MyTreeNode(new Workspace("RadnaPovsina")));
    }
}
