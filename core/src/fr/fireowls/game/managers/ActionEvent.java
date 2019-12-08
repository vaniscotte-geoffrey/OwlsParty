package fr.fireowls.game.managers;

public class ActionEvent {
    public ActionInterface action;
    public BooleanInterface bool;

    public ActionEvent(ActionInterface action, BooleanInterface bool) {
        this.action = action;
        this.bool = bool;
    }

    public void action(){
        if(bool.bool()) action.action();
    }
}
