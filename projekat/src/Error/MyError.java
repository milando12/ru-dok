package Error;

import View.MainFrame;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;

@Getter
@Setter
public class MyError {
    String message;
    int type;
    String title;

    public MyError(String message, int type, String title){
//        JOptionPane.showMessageDialog(MainFrame.getInstance(),message,"Upozorenje", JOptionPane.WARNING_MESSAGE);
        this.message= message;
        this.type=  type;
        this.title= title;
    }
}
