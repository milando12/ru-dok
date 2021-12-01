package Model.tree;

import Model.BackgroundImage;
import Model.tree.nodes.RuNode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Slide extends RuNode {
    private int redniBroj;
    private BackgroundImage backgroundImage;

    public Slide(String name, RuNode parent) {
        super(name, parent);
    }
}
