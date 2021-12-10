package State;

import Model.tree.Prezentation;
import View.mainFrameComponents.WorkspacePanel.PresentationView;

import javax.swing.*;

public interface State {
    void representation(PresentationView presentationView);
}
