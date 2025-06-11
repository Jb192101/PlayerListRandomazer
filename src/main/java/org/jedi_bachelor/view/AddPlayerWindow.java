package org.jedi_bachelor.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddPlayerWindow extends Stage {
    public AddPlayerWindow() {
        setupUI();
    }

    private void setupUI() {
        VBox root = new VBox(10);
        root.setPadding(new Insets(15));
        root.setAlignment(Pos.CENTER);

        GridPane form = new GridPane();
        form.setHgap(10);
        form.setVgap(10);
        form.setAlignment(Pos.CENTER);

        TextField nicknameField = new TextField();
        TextField killsField = new TextField();
        TextField deathsField = new TextField();
        TextField bedsBrokenField = new TextField();

        form.add(new Label("Никнейм:"), 0, 0);
        form.add(nicknameField, 1, 0);
        form.add(new Label("Кол-во убийств:"), 0, 1);
        form.add(killsField, 1, 1);
        form.add(new Label("Кол-во смертей:"), 0, 2);
        form.add(deathsField, 1, 2);
        form.add(new Label("Кол-во сломанных кроватей:"), 0, 3);
        form.add(bedsBrokenField, 1, 3);

        Button addButton = new Button("Добавить");
        addButton.setOnAction(e -> {
            // Здесь будет логика добавления игрока
            this.close();
        });

        root.getChildren().addAll(
                new Label("Добавление нового игрока"),
                form,
                addButton
        );

        Scene scene = new Scene(root, 350, 250);
        this.setScene(scene);
        this.setTitle("Добавить игрока");
    }
}
