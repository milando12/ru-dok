package Factory.NodeFactories;

import Model.tree.Prezentation;
import Model.tree.nodes.RuNode;
import Model.tree.nodes.RuNodeComposit;

public class PresentationFactory extends NodeFactory{
    @Override
    public RuNode createNode(RuNode parent, int slideNum) {
        String name= "Prezentacija "+ (((RuNodeComposit)parent).getChildren().size()+1);
        return new Prezentation(name, parent);
    }
}
