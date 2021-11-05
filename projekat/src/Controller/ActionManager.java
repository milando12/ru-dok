package Controller;

public class ActionManager {
    private InfoAction infoAction;
    private NewAction newAction;
    private PromenaAutoraPrezentacijeAction promenaAutoraPrezentacijeAction;
    private PromenaPozadinskeSlikePrezentacijeAction promenaPozadinskeSlikePrezentacijeAction;

    public ActionManager() {
        initialiseActions();
    }

    private void initialiseActions(){
        infoAction= new InfoAction();
        newAction= new NewAction();
        promenaAutoraPrezentacijeAction= new PromenaAutoraPrezentacijeAction();
        promenaPozadinskeSlikePrezentacijeAction= new PromenaPozadinskeSlikePrezentacijeAction();
    }


    public PromenaAutoraPrezentacijeAction getPromenaAutoraPrezentacijeAction() {
        return promenaAutoraPrezentacijeAction;
    }

    public void setPromenaAutoraPrezentacijeAction(PromenaAutoraPrezentacijeAction promenaAutoraPrezentacijeAction) {
        this.promenaAutoraPrezentacijeAction = promenaAutoraPrezentacijeAction;
    }

    public PromenaPozadinskeSlikePrezentacijeAction getPromenaPozadinskeSlikePrezentacijeAction() {
        return promenaPozadinskeSlikePrezentacijeAction;
    }

    public void setPromenaPozadinskeSlikePrezentacijeAction(PromenaPozadinskeSlikePrezentacijeAction promenaPozadinskeSlikePrezentacijeAction) {
        this.promenaPozadinskeSlikePrezentacijeAction = promenaPozadinskeSlikePrezentacijeAction;
    }

    public InfoAction getInfoAction() {
        return infoAction;
    }
    public void setInfoAction(InfoAction infoAction) {
        this.infoAction = infoAction;
    }
    public NewAction getNewAction() {
        return newAction;
    }
    public void setNewAction(NewAction newAction) {
        this.newAction = newAction;
    }
}
