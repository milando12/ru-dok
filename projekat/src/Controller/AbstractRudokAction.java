package Controller;

import javax.swing.*;
import java.net.URL;

public abstract class AbstractRudokAction extends AbstractAction {
    public Icon loadIcon(String fileName){
        URL imageURL= getClass().getResource(fileName);
        Icon icon= null;

        if (imageURL!= null){
            icon= new ImageIcon(imageURL);
        }else {
            System.err.println("Resurs nije pronadjen:"+ fileName);
        }
        return icon;
    }

}
