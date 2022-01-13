package Model.Slot;

import javax.swing.*;

public class TextSH implements SlotHandler{
    private Slot slot;

    public TextSH(Slot slot) {
        this.slot = slot;
    }

    @Override
    public void save(Object o) {
        slot.setContent((String) ((JTextPane)o).getText());
    }
}
