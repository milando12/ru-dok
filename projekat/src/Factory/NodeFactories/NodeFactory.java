package Factory.NodeFactories;

import Factory.FactoryGenerator;
import Model.tree.nodes.RuNode;
import View.tree.model.MyTreeNode;

public abstract class NodeFactory {
    public MyTreeNode makeTreeNode(MyTreeNode selected){
        RuNode ruNode= createNode(selected.getNode(), selected.getChildCount()+1);
        return new MyTreeNode(ruNode);
    }

    public abstract RuNode createNode(RuNode parent, int slideNum);
}
