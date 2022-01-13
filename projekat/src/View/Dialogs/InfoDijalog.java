package View.Dialogs;

import javax.swing.*;
import java.awt.*;

public class InfoDijalog extends JDialog {
    public InfoDijalog(Frame parent){
        super(parent, "Podaci o studentu", false);

        Toolkit toolkit= Toolkit.getDefaultToolkit();
        Dimension dimension= toolkit.getScreenSize();
        setSize((int)dimension.getWidth()/4, (int) dimension.getHeight()/2);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

//        setLayout( new FlowLayout());
//        add(new JLabel("Milan Došlić RN35/20"));

        Icon icon= new ImageIcon("C:\\Users\\test\\IdeaProjects\\DizajnSoftvera\\rudok-milando12\\projekat\\src\\Controller\\slike\\ja.jpg");

        JLabel slikaLB= new JLabel(icon);
//        add(slikaLB);
        JPanel jediniPN= new JPanel();
        jediniPN.setLayout(new FlowLayout());
        jediniPN.add(new JLabel("Milan Došlić RN35/20"));
        jediniPN.add(slikaLB);

        add(jediniPN);

    }
}
