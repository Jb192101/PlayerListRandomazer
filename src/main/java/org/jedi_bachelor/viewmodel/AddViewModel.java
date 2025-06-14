package org.jedi_bachelor.viewmodel;

import org.jedi_bachelor.model.Model;
import org.jedi_bachelor.model.Player;
import org.jedi_bachelor.view.AddPlayerWindow;

public class AddViewModel extends AbstractViewModel {
    private MainViewModel mvm;

    public AddViewModel(MainViewModel _mvm) {
        this.mvm = _mvm;

        this.window = new AddPlayerWindow(this);
    }

    public void addPlayer(String _nick, int _kills, int _deaths, int _beds) {
        if(_nick != "" && _kills > 0 && _deaths > 0 && _beds > 0) {
            mvm.addPlayer(new Player(_nick, _beds, _kills, _deaths));
        }
    }

}
