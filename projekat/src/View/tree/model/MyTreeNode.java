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
import java.util.Objects;
import java.util.Vector;

@Getter
@Setter
public class MyTreeNode extends DefaultMutableTreeNode {
    private RuNode node;

    public MyTreeNode(RuNode node) {
        this.node = node;
        this.children= new Vector<>();
    }

    public void addChildMTN(MyTreeNode child){
        children.add(child);
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

    public void removeChild(MyTreeNode childNode){
        if (this.getAllowsChildren() && children.contains(childNode)){
            children.remove(childNode);

            if (node instanceof RuNodeComposit){
                ((RuNodeComposit) node).removeChild(childNode.getNode());
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyTreeNode treeNode = (MyTreeNode) o;
        return node.equals(((MyTreeNode) o).getNode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(node);
    }
}
