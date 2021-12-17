package State.EditStates;

import Model.tree.Slide;
import View.SlotView;
import View.mainFrameComponents.WorkspacePanel.SlideView;

import java.awt.*;
import java.util.List;

public abstract class SlotState {
    public abstract void mouseClicked(Point point, Slide slide, List<SlotView> slotViewList);

    public void mouseDragged(Point point, Slide slide) {
    }

    public void mouseReleased() {
    }
}