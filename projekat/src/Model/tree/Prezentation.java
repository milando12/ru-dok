package Model.tree;

import Model.BackgroundImage;
import Model.tree.nodes.RuNode;
import Model.tree.nodes.RuNodeComposit;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Prezentation extends RuNodeComposit {
    private String author;
//    private BackgroundImage theme;

    public Prezentation(String name, RuNode parent) {
        super(name, parent);
    }

    @Override
    public void addChild(RuNode child) {
        if (child instanceof Slide){
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
        if (child instanceof Slide){
            if (this.getChildren() != null || !this.getChildren().isEmpty()){
                this.getChildren().remove(child);
            }
        }
    }

    public void setAuthor(String newAuthor){
        this.author= newAuthor;
        // TODO ovo treba da baci notify
    }

    public void changeTheme(String pictureURL){
        if (pictureURL!= null){
            for (int i = 0; i < this.getChildren().size(); i++) {
                Slide slide= (Slide) this.getChildren().get(i);
                slide.setPictureURL(pictureURL);
            }
        }
        //TODO opali observer da update slideView
    }

//    public void changeBackgroundImage(String img){
//        theme= new BackgroundImage(img);
//        // TODO takodje notify
//    }


}
