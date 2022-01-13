package Model.Slot;

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
    private String content;
    private boolean type;// true tekst, false multimedijalni

    private SlotHandler slotHandler;

    public Slot(Point point, Color color, Stroke stroke, boolean slotType){
        dimension= new Dimension(100,50);
        this.stroke= stroke;
        this.color= color;
        this.point= point;
        this.selection= false;
        this.type= slotType;

        this.slotHandler= setSH();
    }
    public boolean getSelection(){return selection;}

    public void changeSelection(){
        this.selection = !this.selection;
    }

    public boolean getType(){
        return type;
    }

    private SlotHandler setSH(){
        if (type) return new TextSH(this);
        else return new MultimedialSH(this);
    }
}
