package Factory.NodeFactories;

import Model.tree.Project;
import Model.tree.nodes.RuNode;
import Model.tree.nodes.RuNodeComposit;

public class ProjectFactory extends NodeFactory{
    @Override
    public RuNode createNode(RuNode parent, int slideNum) {
        String name= "Projekat "+ (((RuNodeComposit)parent).getChildren().size()+1);
        return new Project(name, parent);
    }
}
