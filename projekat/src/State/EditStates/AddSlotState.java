package State.EditStates;

import Model.Slot;
import Model.tree.Slide;
import View.MainFrame;
import View.SlotView;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.List;

@Getter
@Setter
public class AddSlotState extends SlotState {
    Color c= Color.CYAN;
    Stroke s= new BasicStroke(3);

    @Override
    public void mouseClicked(Point point, Slide slide, List<SlotView> slotViewList) {
        slide.addSlot(new Slot(point, c, s));
    }
}
