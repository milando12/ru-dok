package View.tree.model;

import Model.tree.Prezentation;
import Model.tree.Project;
import Model.tree.Slide;
import Model.tree.Workspace;
import Model.tree.nodes.RuNode;
import Model.tree.nodes.RuNodeComposit;
import Observer.IPublisher;
import Observer.ISubscriber;
import lombok.Getter;
import lombok.Setter;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import java.util.Enumeration;
import java.util.Vector;

@Getter
@Setter
public class MyTreeNode extends DefaultMutableTreeNode {

    private RuNode node;

    public MyTreeNode(RuNode node) {
        this.node = node;
        this.children= new Vector<>();
    }

    public void addChild(MyTreeNode child){
        if (node instanceof Workspace){
            children.add(child);

            ((Workspace) node).addChild(child.getNode());
        }else if (node instanceof Project){
            children.add(child);

            ((Project) node).addChild(child.getNode());

        }else if (node instanceof Prezentation){
            children.add(child);

            ((Prezentation) node).addChild(child.getNode());
        }

    }

    @Override
    public String toString() {
        return node.getName();
    }

    //    @Override
//    public TreeNode getChildAt(int childIndex) {
//        if(node instanceof RuNodeComposit) ((RuNodeComposit) node).getChildren().get(childIndex);
//        return null;
//    }
//
//    @Override
//    public int getChildCount() {
//        if (node instanceof RuNodeComposit) return ((RuNodeComposit) node).getChildren().size();
//        return 0;
//    }
//
//    @Override
//    public TreeNode getParent() {
//        if (node instanceof Workspace) return null;
//        else {
//            return (TreeNode) node.getParent();
//        }
//    }
//
//    @Override
//    public int getIndex(TreeNode node) {
//        return 0;
//    }
//
//    @Override
//    public boolean getAllowsChildren() {
//        if (node instanceof RuNodeComposit) return true;
//        return false;
//    }
//
//    @Override
//    public boolean isLeaf() {
//        if (node instanceof RuNode) return true;
//        return false;
//    }
//
//    @Override
//    public Enumeration<? extends TreeNode> children() {
//        return null;
//    }
//
//    @Override
//    public String toString() {
//        return node.getName();
//    }
//
//    @Override
//    public void insert(MutableTreeNode child, int index) {
//
//    }
//
//    @Override
//    public void remove(int index) {
//
//    }
//
//    @Override
//    public void remove(MutableTreeNode node) {// ovaj node je dete cvora node gore koje brisemo
//        if (this.node instanceof RuNodeComposit)
//            ((RuNodeComposit) this.node).getChildren().remove(node);
//    }
//
//    @Override
//    public void setUserObject(Object object) {
//
//    }
//
//    @Override
//    public void removeFromParent() {
//        if (!(node instanceof Workspace)) {
//            RuNode parent= node.getParent();
//            ((RuNodeComposit)parent).getChildren().remove(node);
//        }
//    }
//
//    @Override
//    public void setParent(MutableTreeNode newParent) {
//
//    }
//
//    public void addChild(RuNode child){
//        MyTreeNode treeNode= new MyTreeNode(child);
//
//        treeNode.set
//        if (node instanceof Workspace){
//            ((Workspace)node).addChild(child);
//
//        }
//    }
//
//    @Override
//    public void addSubscriber(ISubscriber subscriber) {
//
//    }
//
//    @Override
//    public void removeSubsriber(ISubscriber subscriber) {
//
//    }
//
//    @Override
//    public void notifySubscribers(Object nortification) {
//
//    }
}
