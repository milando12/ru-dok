package View.Dialogs;

import Model.Slot.ImagePanel;
import Model.Slot.Slot;
import View.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageFilter;
import java.io.File;

public class PictureChooserDialog extends JDialog {
    private Slot slot;

    private String imgURL;

    private ImagePanel previewIMG;

    private JButton saveBT;
    private JButton openBT;

    private JPanel mainPNL;
    private JPanel toolbarPNL;

    public PictureChooserDialog(Frame parent, Slot slot){
        super(parent, "Choose a picture for slot", true);

        this.slot= slot;

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
        if (slot.getContent()!= null){
            previewIMG= new ImagePanel(slot.getContent());
        }else previewIMG= new ImagePanel();

        saveBT= new JButton("save");
        openBT= new JButton("open");

        imgURL= new String();

        mainPNL= new JPanel();
        toolbarPNL= new JPanel();
    }

    private void initActions(){
        openBT.addActionListener(e -> {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setControlButtonsAreShown(false);
            jFileChooser.setMultiSelectionEnabled(false);
            jFileChooser.showOpenDialog(MainFrame.getInstance());

            if (jFileChooser.getSelectedFile() != null) {
                imgURL = jFileChooser.getSelectedFile().getAbsolutePath();

                previewIMG.setImgURL(imgURL);
                previewIMG.repaint();
                previewIMG.revalidate();
                jFileChooser.setVisible(false);
            }
        });

        saveBT.addActionListener(e -> {
            slot.getSlotHandler().save(imgURL);

            dispose();
        });
    }

    private void makeArrangement(){
        mainPNL.setLayout(new BorderLayout());

        toolbarPNL.add(openBT);
        toolbarPNL.add(saveBT);

        mainPNL.add(toolbarPNL, BorderLayout.NORTH);

        mainPNL.add(previewIMG, BorderLayout.CENTER);

        add(mainPNL);
    }

}
