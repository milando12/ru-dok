package Factory.NodeFactories;

import Model.tree.Slide;
import Model.tree.nodes.RuNode;
import Model.tree.nodes.RuNodeComposit;

public class SlideFactory extends NodeFactory{
    @Override
    public RuNode createNode(RuNode parent, int slideNum) {
        String name= "Slajd "+ (((RuNodeComposit)parent).getChildren().size()+1);
        return new Slide(name, parent, slideNum);
    }
}
