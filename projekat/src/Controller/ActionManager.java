package Controller;

import Controller.EditPresentation.ChangePresentationAction;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActionManager {
    private InfoAction infoAction;
    private NewAction newAction;
    private ChangePresentationAction changePresentation;
    private RemoveAction removeAction;
    private UndoAction undoAction;
    private RedoAction redoAction;
    private ShareAction shareAction;


    public ActionManager() {
        initialiseActions();
    }

    private void initialiseActions(){
        infoAction= new InfoAction();
        newAction= new NewAction();
        changePresentation= new ChangePresentationAction();
        removeAction= new RemoveAction();
        undoAction= new UndoAction();
        redoAction= new RedoAction();
        shareAction= new ShareAction();
    }

}
