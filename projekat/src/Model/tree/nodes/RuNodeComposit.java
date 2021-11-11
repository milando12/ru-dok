package Model.tree.nodes;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class RuNodeComposit extends RuNode {
    private List<RuNode> children= null;

    public RuNodeComposit(String name, RuNode parent) {
        super(name, parent);
    }

    public abstract void addChild(RuNode child);

    public abstract void removeChild(RuNode child);
    }
