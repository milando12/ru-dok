package State.EditStates;

import Model.tree.Slide;
import View.SlotView;

import java.awt.*;
import java.util.List;

public class DeleteSlotState extends SlotState {
    @Override
    public void mouseClicked(Point point, Slide slide, List<SlotView> slotViewList) {
        slide.removeSlots(point,slotViewList);
    }
}
