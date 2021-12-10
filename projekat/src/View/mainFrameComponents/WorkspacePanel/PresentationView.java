package View.mainFrameComponents.WorkspacePanel;

import Model.tree.Prezentation;
import Observer.ISubscriber;
import State.StateManager;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PresentationView extends javax.swing.JPanel implements ISubscriber {
    private Prezentation prezentation;

    private StateManager stateManager;

    public PresentationView(Prezentation prezentation){
        stateManager= new StateManager();
        setPrezentation(prezentation);
        this.stateManager.getCurrent()
                .representation(this);
    }

    public void setPrezentation(Prezentation prezentation){
        this.prezentation= prezentation;
        this.prezentation.addSubscriber(this);
    }

    public void startEditState(){
        this.stateManager.setEditState();
        update(this.prezentation);
    }

    public void startSlideShowState(){
        this.stateManager.setSlideShowState();
        update(this.prezentation);
    }


    @Override
    public void update(Object nortification) {
        removeAll();
        setPrezentation((Prezentation) nortification);
        this.stateManager.getCurrent()
                .representation(this);
        repaint();
        revalidate();
    }
}
