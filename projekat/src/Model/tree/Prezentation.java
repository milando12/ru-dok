package Model.tree;

import Model.BackgroundImage;
import Model.tree.nodes.RuNode;
import Model.tree.nodes.RuNodeComposit;
import Observer.IPublisher;
import Observer.ISubscriber;
import View.MainFrame;
import View.tree.model.MyTreeNode;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Prezentation extends RuNodeComposit {
    private String author;
    private List<Project> shareProjests;


    public Prezentation(String name, RuNode parent) {
        super(name, parent);
        shareProjests= new ArrayList<>();
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

    public void addShareProject(Project project){
        if (!shareProjests.contains(project)){
            shareProjests.add(project);
        }
        project.addChild(this);

        makeTree(project);

        System.out.println(shareProjests);
        notifySubscribers(this);
    }

    private void makeTree(Project project){
        MyTreeNode workspaceMTN= (MyTreeNode) MainFrame.getInstance().getMyModel().getRoot();
        MyTreeNode projectS= new MyTreeNode(project);
        MyTreeNode presetationS= new MyTreeNode(this);
        changeName("Deljena" + getName());


        for (RuNode s:this.getChildren()) {
            MyTreeNode slideMTN= new MyTreeNode(s);

            slideMTN.setParent(presetationS);
            presetationS.addChildMTN(slideMTN);
        }

        for (int i = 0; i < workspaceMTN.getChildCount(); i++) {
            MyTreeNode projectMTN= (MyTreeNode) workspaceMTN.getChildAt(i);

            if (projectMTN.equals(projectS)){
                presetationS.setParent(projectMTN);
                projectMTN.addChildMTN(presetationS);
            }
        }
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyJTree());
        MainFrame.getInstance().getMyJTree().expandPath(MainFrame.getInstance()
                .getMyJTree().getSelectionPath());
    }


//    public void changeName(String name){
//        this.setName(name);
//        ((Project)this.getParent()).notifySubscribers(this);
//    }

}
