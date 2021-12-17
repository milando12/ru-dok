package State;

import Model.tree.Prezentation;
import Model.tree.Slide;
import View.MainFrame;
import View.mainFrameComponents.WorkspacePanel.PresentationView;
import View.mainFrameComponents.WorkspacePanel.SlideView;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Setter
@Getter
public class EditState implements State{
    private JLabel authorLB;

    private javax.swing.JPanel slidesPNL;
    private javax.swing.JPanel previewPNL;
    private javax.swing.JPanel presentationPNL;

    private Prezentation prezentation;

    private JScrollPane slidesScrP;
    private JScrollPane previewScrP;

    private JPanel presentationToolbar;

    private JButton slideShowBT;
    private JButton addSlotStateBT;
    private JButton deleteSlotStateBT;
    private JButton selectSlotStateBT;
    private JButton moveSlotStateBT;
    private JButton colorBT;

    private PresentationView presentationView;


    private void initialiseGUI(){
        slideShowBT= new JButton();
        selectSlotStateBT= new JButton();
        selectSlotStateBT.setIcon(new ImageIcon("C:/Users/test/IdeaProjects" +
                "/DizajnSoftvera/rudok-milando12/projekat/src/Controller/slike/selection.png"));
        moveSlotStateBT= new JButton();
        moveSlotStateBT.setIcon(new ImageIcon("C:/Users/test/IdeaProjects" +
                "/DizajnSoftvera/rudok-milando12/projekat/src/Controller/slike/move.png"));
        colorBT= new JButton();
        colorBT.setIcon(new ImageIcon("C:/Users/test/IdeaProjects" +
                "/DizajnSoftvera/rudok-milando12/projekat/src/Controller/slike/color-palette.png"));
        addSlotStateBT= new JButton();
        addSlotStateBT.setIcon(new ImageIcon("C:/Users/test/IdeaProjects" +
                "/DizajnSoftvera/rudok-milando12/projekat/src/Controller/slike/more.png"));
        addSlotStateBT.setToolTipText("add Slot");
        deleteSlotStateBT= new JButton();
        deleteSlotStateBT.setIcon(new ImageIcon("C:/Users/test/IdeaProjects" +
                "/DizajnSoftvera/rudok-milando12/projekat/src/Controller/slike/eraser.png"));
        deleteSlotStateBT.setToolTipText("delete Slot");

        authorLB= new JLabel(prezentation.getAuthor());
        slidesPNL= new JPanel();
        previewPNL= new JPanel();
        presentationPNL= new JPanel();presentationPNL.setLayout(new BorderLayout());
        presentationToolbar = new JPanel();



        makeSlidesPNL();
        makeSlideShowButton();
        initActions();
    }

    private void initActions(){
        addSlotStateBT.addActionListener(e -> presentationView.startAddSlotState());

        deleteSlotStateBT.addActionListener(e -> presentationView.startDeleteSlotState());
        colorBT.addActionListener(e -> MainFrame.getInstance().setSlotColor(JColorChooser.showDialog(MainFrame.getInstance()
                , "Izaberite boju Slota"
                , Color.CYAN)));
        selectSlotStateBT.addActionListener(e -> presentationView.startSelectSlotState());
        moveSlotStateBT.addActionListener(e -> presentationView.startMoveSlotState());
    }

    private void makeSlideShowButton(){
        slideShowBT.setIcon(new ImageIcon("C:/Users/test/IdeaProjects" +
                "/DizajnSoftvera/rudok-milando12/projekat/src/Controller/slike/slideshow.png"));
        slideShowBT.addActionListener(e -> presentationView.startSlideShowState());
    }

    private void makeSlidesPNL(){
        previewPNL.setBackground(new Color(134,136,138));
        previewScrP = new JScrollPane(previewPNL, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS
                , ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        slidesPNL.setBackground(new Color(134,136,138));
        slidesScrP = new JScrollPane(presentationPNL, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS
                , ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        presentationPNL.add(authorLB, BorderLayout.NORTH);

        if (!prezentation.getChildren().isEmpty()){
//            System.out.println(prezentation.getChildren().size());
            previewPNL.setLayout(new GridLayout(prezentation.getChildren().size(),0, 0,10));
            slidesPNL.setLayout(new GridLayout(prezentation.getChildren().size(),0, 0,20));
            for (int i = 0; i < prezentation.getChildren().size(); i++) {
                Slide slide = (Slide) prezentation.getChildren().get(i);
                slidesPNL.add(new SlideView(slide, MainFrame.getInstance().height()/4));
                previewPNL.add(new SlideView(slide, MainFrame.getInstance().height()/9));
            }
            presentationPNL.add(slidesPNL, BorderLayout.CENTER);
        }
    }

    private void makeArrangements(){
        presentationToolbar.add(slideShowBT, Component.LEFT_ALIGNMENT);
        presentationToolbar.add(addSlotStateBT);
        presentationToolbar.add(deleteSlotStateBT);
        presentationToolbar.add(colorBT);
        presentationToolbar.add(selectSlotStateBT);
        presentationToolbar.add(moveSlotStateBT);

        presentationView.setLayout(new BorderLayout());
        presentationView.add(presentationToolbar, BorderLayout.NORTH);
        presentationView.add(slidesScrP, BorderLayout.CENTER);
        presentationView.add(previewScrP, BorderLayout.WEST);
    }

    public void setPrezentation(Prezentation prezentation){
        this.prezentation= prezentation;
    }

    @Override
    public void representation(PresentationView presentationView) {
        this.presentationView = presentationView;
        setPrezentation(presentationView.getPrezentation());
        initialiseGUI();
        makeArrangements();
    }
}