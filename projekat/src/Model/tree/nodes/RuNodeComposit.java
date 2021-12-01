package Model.tree.nodes;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class RuNodeComposit extends RuNode {
    private List<RuNode> children;

    public RuNodeComposit(String name, RuNode parent) {
        super(name, parent);
        children= new ArrayList<>();
    }

    public abstract void addChild(RuNode child);

    public abstract void removeChild(RuNode child);
}
