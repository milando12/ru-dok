package Model;

import javax.swing.*;
import java.awt.*;

public class Prezentacija extends RuNodeComposit{
    private String ime;
    private PozadinskaSlika pozadinskaSlika;


    public PozadinskaSlika getPozadinskaSlika() {
        return pozadinskaSlika;
    }

    public void setPozadinskaSlika(PozadinskaSlika pozadinskaSlika) {
        this.pozadinskaSlika = pozadinskaSlika;
    }

    @Override
    public String getIme() {
        return ime;
    }

    @Override
    public void setIme(String ime) {
        this.ime = ime;
    }


}
