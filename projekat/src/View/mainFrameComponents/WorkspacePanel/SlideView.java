package View.mainFrameComponents.WorkspacePanel;

import Controller.MouseSlotContoller;
import Model.Slot.Slot;
import Model.tree.Slide;
import Observer.ISubscriber;
import View.SlotView;
import lombok.Getter;
import lombok.Setter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class SlideView extends JPanel implements ISubscriber {
    private Slide slide;

    private JLabel slideNumLB;

    private String urlSlike;

    private List<SlotView> slotViewList;

    public SlideView(Slide slide, int prefHeight){
        this.slide= slide;
        initialiseGUI();
        setPreferredSize(new Dimension(50,prefHeight));
        new MouseSlotContoller(this);
    }
    public SlideView(Slide slide){
        this.slide= slide;
        initialiseGUI();
        add(slideNumLB);
    }

    private void initialiseGUI(){
        slotViewList= new ArrayList<>();
        slideNumLB= new JLabel(String.valueOf(slide.getRedniBroj()));
        urlSlike= slide.getPictureURL();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        BufferedImage img = null;
        try {
            if(urlSlike == null) {
                urlSlike = "C:/Users/test/IdeaProjects/DizajnSoftvera/rudok-milando12/projekat" +
                        "/src/Controller/slike/DefaultBackground.jpg";
            }
            img = ImageIO.read(new File(urlSlike));
        } catch (IOException e) {
        }
        g.drawImage(img,0,0,getWidth(),getHeight(),null);

        slotViewList.removeAll(slotViewList);
        for (Slot s:slide.getSlots()) {
            slotViewList.add(new SlotView(s));
        }
        for (SlotView sv:slotViewList) {
            sv.paint((Graphics2D)g);
        }
        repaint();


    }

    public void setSlide(Slide slide){
        this.slide= slide;
        this.slide.addSubscriber(this);
    }

    @Override
    public void update(Object nortification) {
        removeAll();
        if (nortification instanceof Slide){
            setSlide((Slide) nortification);
        }

        repaint();
        revalidate();
    }}