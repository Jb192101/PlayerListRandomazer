package org.jedi_bachelor.viewmodel;

import org.jedi_bachelor.model.Model;
import org.jedi_bachelor.view.MainWindow;

public class MainViewModel implements ViewModelInterface {
    private MainWindow mw;

    private AddViewModel avm;
    private RemoveViewModel rvm;

    private Model model;

    public MainViewModel() {
        mw = new MainWindow();
        model = new Model();

        avm = new AddViewModel();
        rvm = new RemoveViewModel();
    }

    // Методы работы с окном
    @Override
    public void showWindow() {
        mw.show();
    }

    @Override
    public void closeWindow() {
        mw.close();
    }

    // Методы работы с моделью
}
