package org.jedi_bachelor.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.jedi_bachelor.viewmodel.RemoveViewModel;

public class RemovePlayerWindow extends Stage {
    private Label errorLabel;

    private RemoveViewModel rvm;

    public RemovePlayerWindow(RemoveViewModel _rvm) {
        this.rvm = _rvm;

        setupUI();
    }

    private void setupUI() {
        VBox root = new VBox(10);
        root.setPadding(new Insets(15));
        root.setAlignment(Pos.CENTER);

        TextField nicknameField = new TextField();
        nicknameField.setPromptText("Введите никнейм");

        Button removeButton = new Button("Удалить");
        removeButton.setOnAction(e -> {
            errorLabel.setText("");
            boolean isFinding = rvm.removePlayer(nicknameField.getText());
            if(!isFinding)
                errorLabel.setText("Игрок с таким ником не найден!");
        });

        errorLabel = new Label();
        errorLabel.setStyle("-fx-text-fill: red;");

        root.getChildren().addAll(
                new Label("Удаление игрока"),
                nicknameField,
                removeButton,
                errorLabel
        );

        Scene scene = new Scene(root, 300, 200);
        this.setScene(scene);
        this.setTitle("Удалить игрока");
    }
}
