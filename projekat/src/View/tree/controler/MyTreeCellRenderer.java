package View.tree.controler;

import Model.tree.Prezentation;
import Model.tree.Project;
import Model.tree.Slide;
import Model.tree.Workspace;
import Model.tree.nodes.RuNode;
import View.tree.model.MyTreeNode;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.net.URL;

public class MyTreeCellRenderer extends DefaultTreeCellRenderer {
//    @Override
//    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel
//            , boolean expanded, boolean leaf, int row, boolean hasFocus) {
//        return super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
//    }

        public Component getTreeCellRendererComponent(
            JTree tree,
            Object value,
            boolean sel,
            boolean expanded,
            boolean leaf,
            int row,
            boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel,expanded, leaf, row,hasFocus);
        setOpaque(false);
        if (value instanceof MyTreeNode){
            RuNode node= ((MyTreeNode) value).getNode();

            if (node instanceof Project) {
                URL imageURL = getClass().getResource("slike1/project (1).png");
                Icon icon = null;
                if (imageURL != null)
                    icon = new ImageIcon(imageURL);
                setIcon(icon);
            } else if (node instanceof Prezentation) {
                URL imageURL = getClass().getResource("slike1/add-folder.png");
                Icon icon = null;
                if (imageURL != null)
                    icon = new ImageIcon(imageURL);
                setIcon(icon);
            } else if (node instanceof Slide) {
                URL imageURL = getClass().getResource("slike1/slide-show.png");
                Icon icon = null;
                if (imageURL != null)
                    icon = new ImageIcon(imageURL);
                setIcon(icon);
            } else if (node instanceof Workspace) {
                URL imageURL = getClass().getResource("slike1/folder.png");
                Icon icon = null;
                if (imageURL != null)
                    icon = new ImageIcon(imageURL);
                setIcon(icon);
            }
            return this;

        }
        return this;
    }
}
