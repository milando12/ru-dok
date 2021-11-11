package View;

import Controller.EditPresentation.ChangeAuthorAction;
import Controller.EditPresentation.ChangeThemeAction;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class EditPresentationDialog extends JDialog {

    private JLabel autorLB= new JLabel("Promeni autora prezentacije");
    private JLabel slikaLB= new JLabel("Promeni pozadinsku sliku prezentacije");

    private JTextField autorTF= new JTextField("Unesi ime novog autora");
    private JTextField slikaTF= new JTextField("Unesi ime slike");

    private JButton prviBT= new JButton("Potvrdi");
    private JButton drugiBT= new JButton("Potvrdi");

    public EditPresentationDialog(Frame parent){
        super(parent, "Edit", true);

        Toolkit toolkit= Toolkit.getDefaultToolkit();
        Dimension dimension= toolkit.getScreenSize();
        setSize((int)dimension.getWidth()/4, (int) dimension.getHeight()/2);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        initialiseGUI();
    }

    private void initialiseGUI(){
        JPanel autorIslikaPN= new JPanel(new FlowLayout());

        prviBT.addActionListener(new ChangeAuthorAction(this));
        drugiBT.addActionListener(new ChangeThemeAction(this));

        autorIslikaPN.add(autorLB);
        autorIslikaPN.add(autorTF);
        autorIslikaPN.add(prviBT);
//        add(MainFrame.getInstance().getActionManager().getPromenaAutoraPrezentacijeAction());
//        Zasto ne moze ovo da shvati?

        autorIslikaPN.add(slikaLB);
        autorIslikaPN.add(slikaTF);
        autorIslikaPN.add(drugiBT);

        add(autorIslikaPN);
    }



}
