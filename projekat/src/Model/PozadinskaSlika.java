package Model;

import javax.swing.*;
import java.awt.*;

public class PozadinskaSlika extends JPanel {
    private Image img;

    public PozadinskaSlika(String img) {
        this(new ImageIcon(img).getImage());
    }

    public PozadinskaSlika(Image img) {
        this.img = img;
    }

    public void paintComponent(Graphics g) {
        g.drawImage(img, (int)(this.getSize().getWidth()-img.getWidth(null))/2,
                (int)(this.getSize().getHeight()-img.getHeight(null))/2, null);
    }
}
