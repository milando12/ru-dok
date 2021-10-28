package View;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private static MainFrame instance= null;

    private MainFrame(){
    }

    private void initialize(){
        Toolkit toolkit= Toolkit.getDefaultToolkit();
        Dimension dimension= toolkit.getScreenSize();
        setSize((int)dimension.getWidth()/2, (int)dimension.getHeight()/2);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Rukovodilac Dokumenata");
        setVisible(true);



    }

    public static MainFrame getInstance(){
        if (instance== null){
            instance= new MainFrame();
            instance.initialize();
        }
        return instance;
    }
}
