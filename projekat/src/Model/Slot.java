package Model;

import lombok.Getter;
import lombok.Setter;

import javax.swing.text.Position;
import java.awt.*;

@Getter
@Setter
public class Slot {
    private boolean selection;
    private Dimension dimension;
    private Stroke stroke;
    private Color color;
    private Point point;

    public Slot(Point point, Color color, Stroke stroke){
        dimension= new Dimension(100,50);
        this.stroke= stroke;
        this.color= color;
        this.point= point;
        this.selection= false;
    }
    public boolean getSelection(){return selection;}

    public void changeSelection(){
        this.selection = !this.selection;
    }
}
