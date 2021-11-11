package Model.tree.nodes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class RuNode {
    private String name;
    private RuNode parent;

    public RuNode(String name, RuNode parent) {
        this.name = name;
        this.parent = parent;
    }
}
