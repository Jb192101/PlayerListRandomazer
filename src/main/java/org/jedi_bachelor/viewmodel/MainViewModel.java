package org.jedi_bachelor.viewmodel;

import org.jedi_bachelor.model.Model;
import org.jedi_bachelor.model.Player;
import org.jedi_bachelor.view.MainWindow;

public class MainViewModel extends AbstractViewModel {
    private AddViewModel avm;
    private RemoveViewModel rvm;

    private Model model;

    public MainViewModel() {
        model = new Model();

        avm = new AddViewModel(this);
        rvm = new RemoveViewModel(this);

        this.window = new MainWindow(this);
    }

    // Методы работы с моделью

    // Открытие других окон
    public void openAddWindow() {
        avm.showWindow();
    }

    public void openRemoveWindow() {
        rvm.showWindow();
    }

    // Рандомайзинг
    public boolean randomaze() {
        if(model.getPlayerList().size() < 4 || model.getPlayerList().size() > 8) {
            return false;
        }

        // Процесс рандома
        model.randomaze();

        return true;
    }

    public void addPlayer(Player _p) {
        model.addPlayer(_p);
    }

    public boolean removePlayer(String _nick) {
        return model.removePlayer(_nick);
    }
}
