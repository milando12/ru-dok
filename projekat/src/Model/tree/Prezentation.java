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
    }

    public void changeName(String name){
        this.setName(name);
        ((Project)this.getParent()).notifySubscribers(this);
    }

}
