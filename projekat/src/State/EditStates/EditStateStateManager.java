package State.EditStates;

import State.State;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditStateStateManager {
    private SlotState currentState;
    private AddSlotState addSlotState;
    private DeleteSlotState deleteSlotState;
    private SelectSlotState selectSlotState;
    private MoveSlotState moveSlotState;

    public EditStateStateManager(){
        initialiseStates();
    }

    private void initialiseStates(){
        addSlotState= new AddSlotState();
        deleteSlotState= new DeleteSlotState();
        selectSlotState= new SelectSlotState();
        moveSlotState= new MoveSlotState();
        currentState= null;
    }

    public SlotState getCurrent(){
        return currentState;
    }

    public void setAddSlotState(){
        currentState = addSlotState;
    }

    public void setDeleteSlotState(){
        currentState = deleteSlotState;
    }

    public void setSelectSlotState(){
        currentState = selectSlotState;
    }

    public void setMoveSlotState(){
        currentState = moveSlotState;
    }
}
