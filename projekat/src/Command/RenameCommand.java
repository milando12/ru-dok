package Command;

import Model.tree.Project;
import Model.tree.nodes.RuNode;
import View.MainFrame;

import javax.swing.*;

public class RenameCommand extends AbstractCommand{
    private String newName;
    private String oldName;
    private RuNode node;

    public RenameCommand(String newName, RuNode node) {
        this.newName = newName;
        this.node = node;
        this.oldName= node.getName();
    }

    @Override
    public void doCommand() {
        node.changeName(newName);
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyJTree());
    }

    @Override
    public void undoCommand() {
        node.changeName(oldName);
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyJTree());
    }
}
