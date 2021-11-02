package Controller;

import java.awt.event.ActionEvent;

public class InfoAction extends AbstractRudokAction{

    public InfoAction() {
        putValue(SMALL_ICON, loadIcon("slike/info.jpg"));
        putValue(NAME, "Info");
        putValue(SHORT_DESCRIPTION, "Info");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
