package Controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActionManager {
    private InfoAction infoAction;
    private NewAction newAction;
    private ChangePresentationAction changePresentation;

//    private PromenaAutoraPrezentacijeAction promenaAutoraPrezentacijeAction;
//    private PromenaPozadinskeSlikePrezentacijeAction promenaPozadinskeSlikePrezentacijeAction;

    public ActionManager() {
        initialiseActions();
    }

    private void initialiseActions(){
        infoAction= new InfoAction();
        newAction= new NewAction();
        changePresentation= new ChangePresentationAction();

//        promenaAutoraPrezentacijeAction= new PromenaAutoraPrezentacijeAction();
//        promenaPozadinskeSlikePrezentacijeAction= new PromenaPozadinskeSlikePrezentacijeAction();
    }

}
