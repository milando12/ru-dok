package Model.Slot;

import javax.swing.*;
import java.awt.*;

public class TextSH implements SlotHandler{
    private Slot slot;

    public TextSH(Slot slot) {
        this.slot = slot;
    }

    @Override
    public void save(Object o) {
        slot.setContent((String) ((JTextPane)o).getText());
    }

    @Override
    public void paint(Graphics2D g) {
        if (slot.getContent()!= null)
        g.drawString(slot.getContent(), (int) slot.getPoint().getX(), (int) slot.getPoint().getY());
    }
}
