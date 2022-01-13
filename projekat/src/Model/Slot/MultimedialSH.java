package Model.Slot;

public class MultimedialSH implements SlotHandler{
    private Slot slot;

    public MultimedialSH(Slot slot) {
        this.slot = slot;
    }

    @Override
    public void save(Object o) {
        String url= (String) o;

        slot.setContent(url);
    }
}
