package State.EditStates;

import Model.tree.Slide;
import View.SlotView;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.List;

@Setter
@Getter
public class MoveSlotState extends SlotState{
    private static Point p;
    @Override
    public void mouseClicked(Point point, Slide slide, List<SlotView> slotViewList) {
        p=point;
    }

    @Override
    public void mouseDragged(Point point, Slide slide) {
        slide.setLocationOfSelectedSlots(point, p);
        p=point;
    }

    @Override
    public void mouseReleased() {
        super.mouseReleased();
    }
}
