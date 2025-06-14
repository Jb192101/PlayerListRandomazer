package org.jedi_bachelor.viewmodel;

import javafx.stage.Stage;

abstract public class AbstractViewModel implements ViewModelInterface {
    protected Stage window;

    @Override
    public void showWindow() {
        this.window.show();
    }

    @Override
    public void closeWindow() {
        this.window.close();
    }
}
