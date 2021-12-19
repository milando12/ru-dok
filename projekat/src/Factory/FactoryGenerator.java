package Factory;

import Factory.NodeFactories.NodeFactory;
import Factory.NodeFactories.PresentationFactory;
import Factory.NodeFactories.ProjectFactory;
import Factory.NodeFactories.SlideFactory;
import Model.tree.Prezentation;
import Model.tree.Project;
import Model.tree.Workspace;
import View.tree.model.MyTreeNode;

public class FactoryGenerator {
    private static ProjectFactory projectFactory= new ProjectFactory();
    private static PresentationFactory presentationFactory= new PresentationFactory();
    private static SlideFactory slideFactory= new SlideFactory();

    public static NodeFactory returnNodeFactroy(MyTreeNode myTreeNode){
        if (myTreeNode.getNode() instanceof Workspace){
            return projectFactory;
        }else if (myTreeNode.getNode() instanceof Project){
            return presentationFactory;
        }else if (myTreeNode.getNode() instanceof Prezentation){
            return slideFactory;
        }
        return null;
    }
}
