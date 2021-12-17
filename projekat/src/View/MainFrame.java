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
    private JScrollPane treeScP;
    private JSplitPane treeRadnaSpP;

    private ErrorFactory errorFactory;

    private Color slotColor;

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

        treeScP = new JScrollPane(myJTree);
        treeScP.setPreferredSize(new Dimension((int)dimension.getWidth()/8,9));

        treeRadnaSpP = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, treeScP, radnaPovrsPL);

        slotColor= Color.CYAN;

        add(treeRadnaSpP, BorderLayout.CENTER);
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

    public int height(){
        Toolkit toolkit= Toolkit.getDefaultToolkit();
        Dimension dimension= toolkit.getScreenSize();
        return dimension.height;
    }
    public int width(){
        Toolkit toolkit= Toolkit.getDefaultToolkit();
        Dimension dimension= toolkit.getScreenSize();
        return dimension.width;
    }


}
