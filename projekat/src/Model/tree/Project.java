package Model.tree;

import Model.tree.nodes.RuNode;
import Model.tree.nodes.RuNodeComposit;
import Observer.IPublisher;
import Observer.ISubscriber;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Project extends RuNodeComposit implements IPublisher {

    public Project(String name, RuNode parent) {
        super(name, parent);
    }

    @Override
    public void addChild(RuNode child) {
        if (child instanceof Prezentation){
            if (this.getChildren() == null || this.getChildren().isEmpty()) {
                this.setChildren(new ArrayList<>());
            }
            this.getChildren().add(child);
        }
        notifySubscribers(this);
    }

    @Override
    public void removeChild(RuNode child) {
        if (child instanceof Prezentation){
            if (this.getChildren() != null || !this.getChildren().isEmpty()){
                this.getChildren().remove(child);
                notifySubscribers(this);
            }
        }
    }

    public void changeName(String name){
        this.setName(name);
        notifySubscribers(this);
    }

}
