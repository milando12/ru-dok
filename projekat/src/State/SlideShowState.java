package State;

import Model.tree.Prezentation;
import Model.tree.Slide;
import View.mainFrameComponents.WorkspacePanel.PresentationView;
import View.mainFrameComponents.WorkspacePanel.SlideView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SlideShowState implements State{
    private PresentationView presentationView;

    private Prezentation prezentation;

    private JPanel slidesPNL;

    private JButton nextBT;
    private JButton previousBT;
    private JButton exitBT;

    private CardLayout cardLayout;

    @Override
    public void representation(PresentationView presentationView) {
        this.presentationView= presentationView;
        initGUI();
        makeArrangements();
    }

    private void makeArrangements(){
        presentationView.setLayout(new BorderLayout());
        presentationView.add(exitBT, BorderLayout.NORTH);
        presentationView.add(previousBT, BorderLayout.WEST);
        presentationView.add(nextBT, BorderLayout.EAST);
        presentationView.add(slidesPNL, BorderLayout.CENTER);
    }

    private void initGUI(){
        prezentation= presentationView.getPrezentation();

        slidesPNL = new JPanel(new CardLayout());
        makeSlides();

        nextBT = new JButton(">");
        previousBT = new JButton("<");
        exitBT= new JButton("exit");
        initActions();

        cardLayout= (CardLayout) slidesPNL.getLayout();
    }

    private void initActions() {
        nextBT.addActionListener(e -> {
            CardLayout cardLayout= (CardLayout) slidesPNL.getLayout();
            cardLayout.next(slidesPNL);
        });
        previousBT.addActionListener(e -> {
            CardLayout cardLayout= (CardLayout) slidesPNL.getLayout();
            cardLayout.previous(slidesPNL);
        });
        exitBT.addActionListener(e -> presentationView.startEditState());
    }

    private void makeSlides() {
        if (!prezentation.getChildren().isEmpty()) {
            for (int i = 0; i < prezentation.getChildren().size(); i++) {
                Slide slide = (Slide) prezentation.getChildren().get(i);
                slidesPNL.add(new SlideView(slide));
            }
        }
    }

}
