package Controller;

import java.awt.event.ActionEvent;

public class NewAction extends AbstractRudokAction{

    public NewAction() {
        putValue(SMALL_ICON, loadIcon("slike/new.png"));
        putValue(NAME, "New");
        putValue(SHORT_DESCRIPTION, "New");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
