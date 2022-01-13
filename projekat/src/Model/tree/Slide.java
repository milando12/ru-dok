package Model.tree;

import Model.Slot.Slot;
import Model.tree.nodes.RuNode;
import View.SlotView;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Slide extends RuNode {
    private int redniBroj;
    private String pictureURL;
    private List<Slot> slots;

    public Slide(String name, RuNode parent, int redniBroj) {
        super(name, parent);
        this.redniBroj= redniBroj;
        slots= new ArrayList<>();
    }

    public void slectSlots(Point point, List<SlotView> slotViewList){
        for (SlotView slotView:slotViewList) {
            if (slotView.elementAt(point)){
                slotView.getSlot().changeSelection();
            }
        }
        notifySubscribers(this);
    }

    public void removeSlots(Point point, List<SlotView> slotViewList){
        List<Slot> newSlotsList= new ArrayList<>();
        for (SlotView slotView:slotViewList) {
            if (slotView.elementAt(point)){
                newSlotsList.add(slotView.getSlot());
            }
        }
        slots.removeAll(newSlotsList);
        notifySubscribers(this);
    }

    public List<Slot> getSelectedSlots(){
        List<Slot> slotList = new ArrayList<>();
        for (Slot s:slots) {
            if (s.getSelection()) slotList.add(s);
        }
        return slotList;
    }

    public void setLocationOfSelectedSlots(Point mdPoint, Point startMDPoint){
        for (Slot s:slots) {
            if (s.getSelection()){
                int x= (int)(s.getPoint().getX()+ (mdPoint.getX()- startMDPoint.getX()));
                int y= (int)(s.getPoint().getY()+ (mdPoint.getY()- startMDPoint.getY()));
                s.setPoint(new Point(x, y));
            }
        }
        notifySubscribers(this);
    }

    public void addSlot(Slot slot){
        slots.add(slot);
        notifySubscribers(this);
    }
}
