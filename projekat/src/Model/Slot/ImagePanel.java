package Model.Slot;

import lombok.Getter;
import lombok.Setter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Setter
@Getter
public class ImagePanel extends JPanel {

    private BufferedImage image;
    private String imgURL;

    public ImagePanel() {
//        this.imgURL = "C:\\Users\\test\\IdeaProjects\\DizajnSoftvera" +
//                "\\rudok-milando12\\projekat\\src\\Controller\\slike\\DefaultBackground.jpg";
    }

    public ImagePanel(String url) {
        this.imgURL = url;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            if (imgURL != null) {
                image = ImageIO.read(new File(imgURL));
            }
        } catch (IOException e) {
        }
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
    }
}