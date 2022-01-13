package View.Dialogs;

import Model.Slot.Slot;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;

public class TextEditorDialog extends JDialog {
    private Slot slot;

    private JTextPane slotContentTP;

    private SimpleAttributeSet attributeSet;

    private JButton boldBT;
    private JButton offBoldBT;
    private JButton italicBT;
    private JButton offItalicBT;
    private JButton underlineBT;
    private JButton offUnderlineBT;
    private JButton saveBT;

    private JPanel mainPNL;
    private JPanel toolbarPNL;

    public TextEditorDialog(Frame parent, Slot slot){
        super(parent, "Type slot text", true);

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
        boldBT= new JButton("B");
        italicBT= new JButton("I");
        underlineBT= new JButton("U");
        saveBT= new JButton("Save");
        offBoldBT= new JButton("~B");
        offItalicBT= new JButton("~I");
        offUnderlineBT= new JButton("~U");

        attributeSet= new SimpleAttributeSet();

        slotContentTP = new JTextPane();
        if (slot.getContent() != null){
            slotContentTP.setText(slot.getContent());
        }

        mainPNL= new JPanel();

        toolbarPNL= new JPanel();
    }

    private void initActions(){
        saveBT.addActionListener(e -> {
            slot.getSlotHandler().save(slotContentTP);

//            for (int i = 0; i < slotContentTP.getText().length(); i++) {
//                slotContentTP.getStyledDocument(
//            }

            dispose();
        });

        boldBT.addActionListener(e -> {
            StyleConstants.setBold(attributeSet, true);
            slotContentTP.setCharacterAttributes(attributeSet, true);
        });
        offBoldBT.addActionListener(e -> {
            StyleConstants.setBold(attributeSet, false);
            slotContentTP.setCharacterAttributes(attributeSet, true);
        });

        italicBT.addActionListener(e ->{
            StyleConstants.setItalic(attributeSet, true);
            slotContentTP.setCharacterAttributes(attributeSet, true);
        });
        offItalicBT.addActionListener(e ->{
            StyleConstants.setItalic(attributeSet, false);
            slotContentTP.setCharacterAttributes(attributeSet, true);
        });

        underlineBT.addActionListener(e -> {
            StyleConstants.setUnderline(attributeSet, true);
            slotContentTP.setCharacterAttributes(attributeSet, true);
        });
        offUnderlineBT.addActionListener(e -> {
            StyleConstants.setUnderline(attributeSet, false);
            slotContentTP.setCharacterAttributes(attributeSet, true);
        });
    }

    private void makeArrangement(){
        mainPNL.setLayout(new BorderLayout());

        toolbarPNL.add(boldBT);
        toolbarPNL.add(offBoldBT);
        toolbarPNL.add(italicBT);
        toolbarPNL.add(offItalicBT);
        toolbarPNL.add(underlineBT);
        toolbarPNL.add(offUnderlineBT);
        toolbarPNL.add(saveBT);

        JScrollPane jScrollPane= new JScrollPane(toolbarPNL
        , ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER
        , ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jScrollPane.setPreferredSize(new Dimension(30,60));

        mainPNL.add(jScrollPane, BorderLayout.NORTH);

        mainPNL.add(slotContentTP, BorderLayout.CENTER);

        add(mainPNL);
    }
}
