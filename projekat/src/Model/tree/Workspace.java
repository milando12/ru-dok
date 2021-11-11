package Model.tree;

import Model.tree.nodes.RuNode;
import Model.tree.nodes.RuNodeComposit;

import java.util.ArrayList;

public class Workspace extends RuNodeComposit {
    public Workspace(String name) {
        super(name, null);
    }

    @Override
    public void addChild(RuNode child) {
        if (child instanceof Project){
            if (this.getChildren() == null || this.getChildren().isEmpty()) {
                this.setChildren(new ArrayList<>());
            }
            this.getChildren().add(child);

        }else {
            //TO-DO:
            // mozda treba ovde da ispisem kodrisniku da treba projekat da dodaje
        }
    }

    @Override
    public void removeChild(RuNode child) {
        if (child instanceof Project){
            if (this.getChildren() != null || !this.getChildren().isEmpty()){
                this.getChildren().remove(child);
            }
        }
    }
}
