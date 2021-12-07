package View.mainFrameComponents.WorkspacePanel;

import Model.tree.Prezentation;
import Model.tree.Slide;
import Observer.ISubscriber;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class PresentationView extends JPanel implements ISubscriber {
    private JLabel authorLB;
    private JPanel slidesPNL;
    private JPanel previewPNL;
    private Prezentation prezentation;
    private JScrollPane slidesScrP;
    private JScrollPane previewScrP;

    public PresentationView(Prezentation prezentation){
        setPrezentation(prezentation);
        initialiseGUI();
        makeArrangements();
    }

    private void initialiseGUI(){
        authorLB= new JLabel(prezentation.getAuthor());
        slidesPNL= new JPanel();
        previewPNL= new JPanel();
//        previewPNL.add(new JScrollPane(new JTextArea(100,10)
//        , ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER));

        makeSlidesPNL();
    }

    private void makeSlidesPNL(){
        slidesPNL.setBackground(new Color(134,136,138));
        previewPNL.setBackground(new Color(134,136,138));
        previewScrP = new JScrollPane(previewPNL, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS
                , ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        slidesScrP = new JScrollPane(slidesPNL, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS
                , ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        if (!prezentation.getChildren().isEmpty()){
            previewPNL.setLayout(new GridLayout(prezentation.getChildren().size(),0, 0,10));
            slidesPNL.setLayout(new GridLayout(prezentation.getChildren().size(),0, 0,20));
            for (int i = 0; i < prezentation.getChildren().size(); i++) {
                Slide slide = (Slide) prezentation.getChildren().get(i);
                slidesPNL.add(new SlideView(slide, this.getHeight()/2));
                previewPNL.add(new SlideView(slide, this.getHeight()/6));
            }
        }
    }

    private void makeArrangements(){
        setLayout(new BorderLayout());
        add(authorLB, BorderLayout.NORTH);
        add(slidesScrP, BorderLayout.CENTER);
        add(previewScrP, BorderLayout.WEST);
    }

    public void setPrezentation(Prezentation prezentation){
        this.prezentation= prezentation;
        this.prezentation.addSubscriber(this);
    }

    @Override
    public void update(Object nortification) {
        removeAll();
        setPrezentation((Prezentation) nortification);
        initialiseGUI();
        makeArrangements();
        repaint();
        revalidate();
    }
}
