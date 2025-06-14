package org.jedi_bachelor.viewmodel;

import org.jedi_bachelor.view.RemovePlayerWindow;

public class RemoveViewModel extends AbstractViewModel {
    private MainViewModel mvm;

    public RemoveViewModel(MainViewModel _mvm) {
        this.mvm = _mvm;

        this.window = new RemovePlayerWindow(this);
    }

    public boolean removePlayer(String _nick) {
        return mvm.removePlayer(_nick);
    }
}
