package Command;

import View.MainFrame;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {
    private List<AbstractCommand> commandList;

    private int currentCommand;

    public CommandManager(){
        this.commandList= new ArrayList<>();
        this.currentCommand= 0;
    }

    public void addCommand(AbstractCommand command){
        while(currentCommand < commandList.size())
            commandList.remove(currentCommand);
        commandList.add(command);
        doCommand();
    }

    public void doCommand(){
        if(currentCommand < commandList.size()){
            commandList.get(currentCommand++).doCommand();
            MainFrame.getInstance().getActionManager().getUndoAction().setEnabled(true);
        }
        if(currentCommand== commandList.size()){
            MainFrame.getInstance().getActionManager().getRedoAction().setEnabled(false);
        }
    }

    /*
     * Metoda koja poziva redo konkretne komande
     */
    public void undoCommand(){
        if(currentCommand > 0){
            MainFrame.getInstance().getActionManager().getRedoAction().setEnabled(true);
            commandList.get(--currentCommand).undoCommand();
//            for (AbstractCommand a:commandList) {
//                System.out.println(a);
//            }
        }
        if(currentCommand==0){
            MainFrame.getInstance().getActionManager().getUndoAction().setEnabled(false);
        }
    }
}
