package View.mainFrameComponents.WorkspacePanel;

import Model.BackgroundImage;
import Model.tree.Slide;
import lombok.Getter;
import lombok.Setter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Getter
@Setter
public class SlideView extends JPanel {
    private Slide slide;
    private JLabel slideNumLB;
    private String urlSlike;

    public SlideView(Slide slide, int prefHeight){
        this.slide= slide;
        initialiseGUI();
        setPreferredSize(new Dimension(50,prefHeight));
    }

    private void initialiseGUI(){
        slideNumLB= new JLabel(String.valueOf(slide.getRedniBroj()));
        urlSlike= slide.getPictureURL();

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        BufferedImage img = null;
        try {
            if(urlSlike == null) {
                urlSlike = "C:\\Users\\test\\IdeaProjects\\DizajnSoftvera\\rudok-milando12\\projekat\\src\\Controller\\slike\\DefaultBackground.jpg";
            }
            img = ImageIO.read(new File(urlSlike));
        } catch (IOException e) {
        }
        g.drawImage(img,0,0,getWidth(),getHeight(),null);
    }
}
