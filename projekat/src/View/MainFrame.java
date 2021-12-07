package View;

import Controller.ActionManager;
import Observer.ISubscriber;
import View.mainFrameComponents.MyMenuBar;
import View.mainFrameComponents.MyToolBar;
import View.tree.model.MyModel;
import View.tree.view.MyJTree;
import Error.MyError;
import Error.ErrorFactory;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class MainFrame extends JFrame implements ISubscriber {

    private static MainFrame instance= null;

    private ActionManager actionManager;
    private MyJTree myJTree;
    private MyModel myModel;

    private JPanel stabloPL;
    private JPanel radnaPovrsPL;
    private JScrollPane stabloScP;
    private JSplitPane stblRadnaSpP;

    private ErrorFactory errorFactory;

    private MainFrame(){
        actionManager= new ActionManager();
        setErrorFactory();
    }

    private void setErrorFactory(){
        this.errorFactory= ErrorFactory.getInstance();
        this.errorFactory.addSubscriber(this);
    }

    private void initialiseTree(){
        myJTree= new MyJTree();
        myModel= new MyModel();

        myJTree.setModel(myModel);

    }

    private void initializeGUI(){
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

        stabloPL= new JPanel();
        radnaPovrsPL= new JPanel();


        stabloScP= new JScrollPane(myJTree);
        stabloScP.setPreferredSize(new Dimension((int)dimension.getWidth()/8,9));

//        stabloPL.add(stabloScP, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
//                , JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        stblRadnaSpP= new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, stabloScP, radnaPovrsPL);

        add(stblRadnaSpP, BorderLayout.CENTER);
    }

    @Override
    public void update(Object nortification) {
        if (nortification instanceof MyError){
            JOptionPane.showMessageDialog(this , ((MyError)nortification).getMessage()
            ,((MyError)nortification).getTitle(), ((MyError)nortification).getType());
        }
    }

    public static MainFrame getInstance(){
        if (instance== null){
            instance= new MainFrame();
            instance.initialiseTree();
            instance.initializeGUI();
        }
        return instance;
    }



}
