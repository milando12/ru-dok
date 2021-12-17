package View.mainFrameComponents.WorkspacePanel;

import Model.tree.Prezentation;
import Model.tree.Project;
import Model.tree.Slide;
import Model.tree.nodes.RuNode;
import Observer.ISubscriber;
import View.MainFrame;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Setter
@Getter
public class ProjectView extends JPanel implements ISubscriber {
    private JLabel projectName;
    private JTabbedPane presentationsTP;
    private Project project;

    public ProjectView(Project project){
        setProject(project);
        initialiseGUI();
        makeArrangement();
    }

    private void initialiseGUI(){
        projectName= new JLabel(project.getName());
        presentationsTP= new JTabbedPane(SwingConstants.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
        makeTP();
    }

    private void makeTP(){
        if (!project.getChildren().isEmpty()){
            for (int i = 0; i < project.getChildren().size(); i++) {
                Prezentation presentation= (Prezentation) project.getChildren().get(i);
                if (presentation.getAuthor()== null) presentation.setAuthor("MILAN");// default
                presentationsTP.addTab(presentation.getName(), new PresentationView(presentation));
            }

        }
    }

    private void makeArrangement(){
        setLayout(new BorderLayout());
        add(projectName, BorderLayout.NORTH);
        add(presentationsTP, BorderLayout.CENTER);
    }

    @Override
    public void update(Object nortification) {
        removeAll();
        if (nortification instanceof Project && nortification!=null) setProject((Project) nortification);
        initialiseGUI();
        makeArrangement();
        repaint();
        revalidate();
    }

    public void setProject(Project project){
        this.project= project;
        this.project.addSubscriber(this);
    }

}
