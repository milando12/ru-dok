import Model.Slot.Slot;
import View.Dialogs.TextEditorDialog;
import View.MainFrame;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        MainFrame osnovniProzor= MainFrame.getInstance();
        osnovniProzor.setVisible(true);
//        TextEditorDialog textEditorDialog= new TextEditorDialog(MainFrame.getInstance()
//                , new Slot(null, null, null, true));
//        textEditorDialog.setVisible(true);
    }
}
