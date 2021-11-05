package View;

import javax.swing.*;
import java.awt.*;

public class EditPrezentacijaDijalog extends JDialog {
    public EditPrezentacijaDijalog(Frame parent){
        super(parent, "Edit", false);

        Toolkit toolkit= Toolkit.getDefaultToolkit();
        Dimension dimension= toolkit.getScreenSize();
        setSize((int)dimension.getWidth()/4, (int) dimension.getHeight()/2);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JPanel autorIslikaPN= new JPanel(new FlowLayout());

        JLabel autorLB= new JLabel("Promeni autora prezentacije");
        JLabel slikaLB= new JLabel("Promeni pozadinsku sliku prezentacije");

        JTextField autorTF= new JTextField("Unesi ime novog autora");
        JTextField slikaTF= new JTextField("Unesi ime slike");

        autorIslikaPN.add(autorLB);
        autorIslikaPN.add(autorTF);
//        add(MainFrame.getInstance().getActionManager().getPromenaAutoraPrezentacijeAction());
//        Zasto ne moze ovo da shvati?

        autorIslikaPN.add(slikaLB);
        autorIslikaPN.add(slikaTF);
    }




}
