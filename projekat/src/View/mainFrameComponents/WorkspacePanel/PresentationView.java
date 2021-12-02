package View.mainFrameComponents.WorkspacePanel;

import Model.BackgroundImage;
import Model.tree.Prezentation;
import Model.tree.Slide;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PresentationView extends JPanel {
    private JLabel authorLB;
    private JPanel slidesPNL;
    private Prezentation prezentation;
    private JScrollPane scrollPane;

    public PresentationView(Prezentation prezentation){
        this.prezentation= prezentation;
        initialiseGUI();
        makeArrangements();
    }

    private void initialiseGUI(){
        authorLB= new JLabel(prezentation.getAuthor());
        slidesPNL= new JPanel();

        makePNL();
    }

    private void makePNL(){
        slidesPNL.setBackground(new Color(134,136,138));
        scrollPane= new JScrollPane(slidesPNL, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS
                , ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        if (!prezentation.getChildren().isEmpty()){
            slidesPNL.setLayout(new GridLayout(prezentation.getChildren().size(),0, 0,20));
            for (int i = 0; i < prezentation.getChildren().size(); i++) {
                Slide slide = (Slide) prezentation.getChildren().get(i);
                slidesPNL.add(new SlideView(slide));
            }
        }
    }

    private void makeArrangements(){
        setLayout(new BorderLayout());
        add(authorLB, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }


}
