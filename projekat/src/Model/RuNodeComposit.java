package Model;

import java.util.List;

public abstract class RuNodeComposit extends RuNode{
    private List<RuNode> children;

    public List<RuNode> getChildren() {
        return children;
    }

    public void setChildren(List<RuNode> children) {
        this.children = children;
    }
}
