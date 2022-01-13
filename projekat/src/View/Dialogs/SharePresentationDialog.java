package View.Dialogs;

import Model.tree.Prezentation;
import Model.tree.Project;
import Model.tree.Workspace;
import Model.tree.nodes.RuNode;
import View.MainFrame;
import View.tree.model.MyTreeNode;
import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;

public class SharePresentationDialog extends JDialog {
    private JLabel instructionLB;

    private JTextField projectTF;

    private JButton confirmationBT;

    private JPanel mainPNL;

    public SharePresentationDialog(Frame parent){
        super(parent, "Share Presentation", true);

        Toolkit toolkit= Toolkit.getDefaultToolkit();
        Dimension dimension= toolkit.getScreenSize();
        setSize((int)dimension.getWidth()/4, (int) dimension.getHeight()/2);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        initialiseGUI();
        initActions();
        makeArrangement();
    }

    private void initialiseGUI(){
        instructionLB= new JLabel("<html><p>Upisite ime projekta s kojim zelite da " +
                "podelite selektovanu prezentaciju.<html><p>");
        projectTF= new JTextField();
        confirmationBT= new JButton("Potvrdi");
        mainPNL= new JPanel();
    }

    private void initActions(){
        confirmationBT.addActionListener(e -> {
            String projectName= projectTF.getText();

            Prezentation prezentationTBS= (Prezentation) ((MyTreeNode) MainFrame.getInstance().getMyJTree()
                    .getLastSelectedPathComponent()).getNode();

            Workspace workspace= (Workspace) prezentationTBS.getParent().getParent();

            for (RuNode project:workspace.getChildren()) {
                if (projectName.equals(project.getName())){
                    prezentationTBS.addShareProject((Project) project);
                }
            }
        });
    }

    private void makeArrangement(){
        mainPNL.setLayout(new GridLayout(3, 0, 0, 40));
        mainPNL.add(instructionLB);
        mainPNL.add(projectTF);
        mainPNL.add(confirmationBT);

        add(mainPNL);
    }
}
