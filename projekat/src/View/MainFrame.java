package View;

import Controller.ActionManager;
import Model.MyMenuBar;
import Model.MyToolBar;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private static MainFrame instance= null;

    private ActionManager actionManager;

    private MainFrame(){
        actionManager= new ActionManager();
    }

    private void initialize(){
        Toolkit toolkit= Toolkit.getDefaultToolkit();
        Dimension dimension= toolkit.getScreenSize();
        setSize((int)dimension.getWidth()/2, (int)dimension.getHeight()/2);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Rukovodilac Dokumenata");
        setVisible(true);

        MyMenuBar menuBar= new MyMenuBar();
        setJMenuBar(menuBar);

        MyToolBar toolBar= new MyToolBar(this);
        add(toolBar, BorderLayout.NORTH);

        JPanel stabloPL= new JPanel();
        JPanel radnaPovrsPL= new JPanel();

        JScrollPane stabloScP= new JScrollPane(stabloPL);
        stabloPL.setPreferredSize(new Dimension((int)dimension.getWidth()/8,9));

//        stabloPL.add(stabloScP, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
//                , JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        JSplitPane stblRadnaSpP= new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, stabloPL, radnaPovrsPL);

        add(stblRadnaSpP, BorderLayout.CENTER);
    }

    public static MainFrame getInstance(){
        if (instance== null){
            instance= new MainFrame();
            instance.initialize();
        }
        return instance;
    }

    public ActionManager getActionManager() {
        return actionManager;
    }

    public void setActionManager(ActionManager actionManager) {
        this.actionManager = actionManager;
    }
}
