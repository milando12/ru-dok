package Model.tree.nodes;

import Model.tree.Project;
import Model.tree.Workspace;
import Observer.IPublisher;
import Observer.ISubscriber;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class RuNode implements IPublisher {
    private String name;
    private RuNode parent;
    private List<ISubscriber> subscribers;


    public RuNode(String name, RuNode parent) {
        this.name = name;
        this.parent = parent;
    }

    @Override
    public void addSubscriber(ISubscriber subscriber) {
        if (subscribers==null) subscribers= new ArrayList<>();
        else if (subscriber== null || subscribers.contains(subscriber)) return;
        subscribers.add(subscriber);
    }

    @Override
    public void removeSubsriber(ISubscriber subscriber) {
        if (subscribers== null || subscriber==null|| !subscribers.contains(subscriber)) return;
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers(Object notification) {
        if(notification == null || this.subscribers == null || this.subscribers.isEmpty()) return;

        for (ISubscriber listener: subscribers) {

            listener.update(notification);
        }
    }

    public void changeName(String name){
        this.setName(name);
        RuNode project= this;
        if (!(project instanceof Workspace)){
            while (!(project instanceof Project))
                project= project.getParent();
            project.notifySubscribers(project);
        }
    }

}
