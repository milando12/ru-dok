package State.EditStates;

import Model.Slot;
import Model.tree.Slide;
import View.SlotView;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.List;

@Getter
@Setter
public class AddSlotState extends SlotState {
    private Color c= Color.CYAN;
    private float strokeWidth= 3;
    private boolean abruptness= false;
    private Stroke s;

    @Override
    public void mouseClicked(Point point, Slide slide, List<SlotView> slotViewList) {
        if (abruptness){
            s= new BasicStroke(strokeWidth,
                    BasicStroke.CAP_SQUARE,
                    BasicStroke.JOIN_MITER,
                    10.0f,
                    new float[]{18,8},
                    0.0f);
        }else s=  new BasicStroke(strokeWidth);

        slide.addSlot(new Slot(point, c, s));
    }

    public void changeAbruptness(){
        this.abruptness= !this.abruptness;
    }
}
