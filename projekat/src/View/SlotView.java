package View;

import Model.Slot.Slot;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public class SlotView {
    private Slot slot;
    private Shape shape;
    
    public SlotView(Slot slot){
        this.slot= slot;
        shape= new Rectangle((int) slot.getPoint().getX(), (int)slot.getPoint().getY()
                , (int)slot.getDimension().getWidth(), (int)slot.getDimension().getHeight());
    }

    public void paint(Graphics2D g){
        g.setPaint(slot.getColor());
        g.fill(shape);
        g.setStroke(slot.getStroke());
        g.setPaint(Color.BLACK);
        g.draw(shape);
        if (slot.getSelection()){
            g.setStroke(slot.getStroke());
            g.setPaint(Color.RED);
            g.draw(shape);
        }
    }

    public boolean elementAt(Point point){
        return shape.contains(point);
    }

    public void setLocation(Point point){

    }
}
