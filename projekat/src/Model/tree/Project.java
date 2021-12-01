package Model.tree;

import Model.tree.nodes.RuNode;
import Model.tree.nodes.RuNodeComposit;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Project extends RuNodeComposit {

    public Project(String name, RuNode parent) {
        super(name, parent);
    }

    @Override
    public void addChild(RuNode child) {
        if (child instanceof Prezentation){
            if (this.getChildren() == null || this.getChildren().isEmpty()) {
                this.setChildren(new ArrayList<>());
                this.getChildren().add(child);
            }else {
                this.getChildren().add(child);
            }
        }else {
            //TODO:
            // mozda treba ovde da ispisem kodrisniku da treba projekat da dodaje
        }
    }

    @Override
    public void removeChild(RuNode child) {
        if (child instanceof Prezentation){
            if (this.getChildren() != null || !this.getChildren().isEmpty()){
                this.getChildren().remove(child);
            }
        }
    }
}
