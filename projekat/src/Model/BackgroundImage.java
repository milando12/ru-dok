package Model;

import javax.swing.*;
import java.awt.*;

public class BackgroundImage extends JPanel {
    private Image img;

    public BackgroundImage(String img) {
        this( new ImageIcon(img).getImage());
    }

    public BackgroundImage(Image img) {
        this.img = img;
    }

    public void paintComponent(Graphics g) {
        g.drawImage(img, (int)(this.getSize().getWidth()-img.getWidth(null))/2,
                (int)(this.getSize().getHeight()-img.getHeight(null))/2, null);
    }
}
