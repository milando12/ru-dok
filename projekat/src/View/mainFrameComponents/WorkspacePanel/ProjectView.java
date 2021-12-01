package View.mainFrameComponents.WorkspacePanel;

import Model.tree.Prezentation;
import Model.tree.Project;
import Model.tree.Slide;

import javax.swing.*;
import java.awt.*;

public class ProjectView extends JPanel {
    private JLabel projectName;
    private JTabbedPane presentationsTP;
    private Project project;

    public ProjectView(Project project){
        this.project= project;
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
                presentation.setAuthor("MILAN");
//                System.out.println(presentation.getAuthor());
                presentationsTP.addTab(presentation.getName(), new PresentationView(presentation));
            }

        }
    }

    private void makeArrangement(){
        setLayout(new BorderLayout());
        add(projectName, BorderLayout.NORTH);
        add(presentationsTP, BorderLayout.CENTER);
    }

}
















/*private JLabel projectName;
    private JLabel presentationAuthor;
    private JTabbedPane presentation;
    private Project project;
    private JPanel slideView;

    public ProjectView(Project project){
        this.project= project;
        projectName.setText(this.project.getName());
        slideView= new JPanel();

        initialiseGUI();
    }

    private void initialiseGUI(){

    }

    private void initializeTabbedPane(){
        presentation= new JTabbedPane(SwingConstants.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);

        for (int i = 0; i < project.getChildren().size(); i++) {
            Prezentation prezentacija= (Prezentation) project.getChildren().get(i);
            presentation.addTab(prezentacija.getName(), slideView);
            //TODO napravi prezentacionog autora tj inicijalizuj sta vec

            for (int j = 0; j <prezentacija.getChildren().size() ; j++) {
                Slide slajd= (Slide) prezentacija.getChildren().get(j);
                slideView.add(new JPanel());// mzd preko neke metode mozemo da napravimo da se menja
                                            // tema SlideViewu tako sto prodje kroz sve slajdove i
                // SVIMA PROMENI POZadinsku sliku a prvi put cemo je setovati
                // takodje panel mora da ima scrollPane
            }
        }
    }*/
