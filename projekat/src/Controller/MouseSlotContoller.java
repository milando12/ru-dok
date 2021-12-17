package Controller;

import Model.tree.Slide;
import View.MainFrame;
import View.SlotView;
import View.mainFrameComponents.WorkspacePanel.PresentationView;
import View.mainFrameComponents.WorkspacePanel.ProjectView;
import View.mainFrameComponents.WorkspacePanel.SlideView;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class MouseSlotContoller extends MouseAdapter {
    private Slide slide;
    private SlideView slideView;
    private List<SlotView> slotViewList;

    public MouseSlotContoller(SlideView slideView){
        slide= slideView.getSlide();
        this.slideView= slideView;
        this.slotViewList= slideView.getSlotViewList();
        this.slideView.addMouseMotionListener(this);
        this.slideView.addMouseListener(this);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        PresentationView focusedPresentation= (PresentationView) ((ProjectView)MainFrame.getInstance().getTreeRadnaSpP()
                .getRightComponent()).getPresentationsTP().getSelectedComponent();

        if (focusedPresentation.getEditStateStateManager().getCurrent() != null){
            focusedPresentation.getEditStateStateManager().getCurrent()
                    .mouseDragged(e.getPoint(), slide);
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
//        System.out.println("Kliknuo si na slajd na tacku x="+ e.getX()+ " y="+ e.getY()+'\n'
//                + e.getPoint()+'\n'+ e.getXOnScreen()+'\n'+ e.getYOnScreen()
//                +'\n'+ e.getLocationOnScreen());
        PresentationView focusedPresentation= (PresentationView) ((ProjectView)MainFrame.getInstance().getTreeRadnaSpP()
                .getRightComponent()).getPresentationsTP().getSelectedComponent();

        if (focusedPresentation.getEditStateStateManager().getCurrent() != null){
            focusedPresentation.getEditStateStateManager().getCurrent()
                    .mouseClicked(e.getPoint(), slide, slotViewList);
        }
    }

}
