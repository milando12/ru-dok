package Model.tree;

import Model.BackgroundImage;
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
public class Prezentation extends RuNodeComposit implements IPublisher {
    private String author;
    private List<ISubscriber> subscribers;


    public Prezentation(String name, RuNode parent) {
        super(name, parent);
    }

    @Override
    public void addChild(RuNode child) {
        if (child instanceof Slide){
            if (this.getChildren() == null || this.getChildren().isEmpty()) {
                this.setChildren(new ArrayList<>());
            }
            this.getChildren().add(child);
        }else {
            //TODO:
            // mozda treba ovde da ispisem kodrisniku da treba projekat da dodaje
        }
        notifySubscribers(this);
    }

    @Override
    public void removeChild(RuNode child) {
        if (child instanceof Slide){
            if (this.getChildren() != null || !this.getChildren().isEmpty()){
                this.getChildren().remove(child);
                notifySubscribers(this);
            }
        }
    }

    public void setAuthor(String newAuthor){
        this.author= newAuthor;
        notifySubscribers(this);
    }

    public void changeTheme(String pictureURL){
        if (pictureURL!= null){
            for (int i = 0; i < this.getChildren().size(); i++) {
                Slide slide= (Slide) this.getChildren().get(i);
                slide.setPictureURL(pictureURL);
            }
            notifySubscribers(this);
        }
        //TODO opali observer da update slideView
    }

    public void changeName(String name){
        this.setName(name);
        notifySubscribers(this);
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
}
