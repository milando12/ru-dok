package View.mainFrameComponents.WorkspacePanel;

import Model.BackgroundImage;
import Model.tree.Slide;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class SlideView extends JPanel {
    private BackgroundImage backgroundImage;
    private Slide slide;
    private JLabel slideNumLB;

    public SlideView(Slide slide){
        this.slide= slide;
        initialiseGUI();
        setPreferredSize(new Dimension(50,150));
    }

    private void initialiseGUI(){
        backgroundImage= slide.getBackgroundImage();
        slideNumLB= new JLabel(String.valueOf(slide.getRedniBroj()));

    }
}
