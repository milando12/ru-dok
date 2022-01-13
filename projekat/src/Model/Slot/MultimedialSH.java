package Model.Slot;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MultimedialSH implements SlotHandler{
    private Slot slot;

    public MultimedialSH(Slot slot) {
        this.slot = slot;
    }

    @Override
    public void save(Object o) {
        String url= (String) o;

        slot.setContent(url);
    }

    @Override
    public void paint(Graphics2D g) {
//        g.drawImage;
        BufferedImage img = null;
        String urlSlike = slot.getContent();
        try {
            if(urlSlike != null) {
                img = ImageIO.read(new File(urlSlike));
            }
        } catch (IOException e) {
        }
        if(img!= null)
            g.drawImage(img,(int) slot.getPoint().getX(),(int) slot.getPoint().getY()
                    , img.getWidth()/15, img.getHeight()/15,null);
        else {
            g.setPaint(Color.WHITE);
            g.fillRect((int) slot.getPoint().getX(), (int) slot.getPoint().getY()
                    , (int)slot.getDimension().getWidth(),(int) slot.getDimension().getHeight());
        }
    }
}
