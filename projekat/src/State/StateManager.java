package State;

public class StateManager {
    private State currentState;
    private EditState editState;
    private SlideShowState slideShowState;

    public StateManager(){
        initialiseStates();
    }

    private void initialiseStates(){
        editState= new EditState();
        slideShowState= new SlideShowState();
        currentState= editState;
    }

    public State getCurrent(){
        return currentState;
    }

    public void setEditState(){
        currentState = editState;
    }

    public void setSlideShowState(){
        currentState = slideShowState;
    }


}
