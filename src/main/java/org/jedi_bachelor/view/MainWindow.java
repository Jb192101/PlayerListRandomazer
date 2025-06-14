package org.jedi_bachelor.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.jedi_bachelor.viewmodel.MainViewModel;

public class MainWindow extends Stage {
    MainViewModel mvm;

    public MainWindow(MainViewModel _mvm) {
        this.mvm = _mvm;

        setupUI();
    }

    private void setupUI() {
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));

        HBox buttonPanel = createButtonPanel();
        root.setBottom(buttonPanel);

        VBox teamsContainer = createTeamsContainer();
        root.setCenter(teamsContainer);

        VBox playersPanel = createPlayersPanel();
        root.setRight(playersPanel);

        Scene scene = new Scene(root, 500, 400);
        this.setResizable(false);
        this.setTitle("Рандомайзер команд");
        this.setScene(scene);
    }

    private HBox createButtonPanel() {
        HBox buttonPanel = new HBox(10);
        buttonPanel.setAlignment(Pos.CENTER_LEFT);
        buttonPanel.setPadding(new Insets(10));

        Button addPlayerBtn = new Button("Добавить игрока");
        Button removePlayerBtn = new Button("Удалить игрока");
        Button randomBtn = new Button("Рандом");

        addPlayerBtn.setOnAction(e -> mvm.openAddWindow());
        removePlayerBtn.setOnAction(e -> mvm.openRemoveWindow());
        randomBtn.setOnAction(e -> mvm.randomaze());

        buttonPanel.getChildren().addAll(addPlayerBtn, removePlayerBtn, randomBtn);

        return buttonPanel;
    }

    private VBox createTeamsContainer() {
        VBox teamsContainer = new VBox(10);
        teamsContainer.setPadding(new Insets(10));

        Label teamsTitle = new Label("Команды");
        teamsTitle.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        teamsContainer.getChildren().add(teamsTitle);

        GridPane teamsGrid = new GridPane();
        teamsGrid.setHgap(10);
        teamsGrid.setVgap(10);

        for (int i = 0; i < 4; i++) {
            VBox teamBox = createTeamBox(i + 1);
            teamsGrid.add(teamBox, i % 2, i / 2);
        }

        teamsContainer.getChildren().add(teamsGrid);
        return teamsContainer;
    }

    private VBox createTeamBox(int teamNumber) {
        VBox teamBox = new VBox(5);
        teamBox.setStyle("-fx-border-color: gray; -fx-border-radius: 5; -fx-padding: 10;");

        Label teamLabel = new Label("Команда " + teamNumber);
        teamLabel.setStyle("-fx-font-weight: bold;");

        Label teamContent = new Label();
        teamContent.setMinSize(100, 50);

        teamBox.getChildren().addAll(teamLabel, teamContent);
        return teamBox;
    }

    private VBox createPlayersPanel() {
        VBox playersPanel = new VBox(10);
        playersPanel.setPadding(new Insets(10));
        playersPanel.setMinWidth(200);

        Label playersTitle = new Label("Список игроков");
        playersTitle.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        ListView<String> playersList = new ListView<>();
        playersList.setPlaceholder(new Label("Нет игроков"));

        playersPanel.getChildren().addAll(playersTitle, playersList);
        return playersPanel;
    }
}
