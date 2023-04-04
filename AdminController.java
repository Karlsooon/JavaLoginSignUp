package com.example.demo4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminController {

    @FXML
    private Button adminLogin;

    @FXML
    private Button cancelButton;

    @FXML
    private Button cancelButton1;

    @FXML
    private Label invalidLoginCredentials;

    @FXML
    private Label invalidSignupCredentials;

    @FXML
    private PasswordField specialCode;
    private Stage stage;
    private Scene scene;
    private Parent parent;
    String errorStyle = String.format("-fx-border-color: RED; -fx-border-width: 2; -fx-border-radius: 5;");


    @FXML
    public void SwitchToScene1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    protected void onCancelButtonClick() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    public void SwitchToSceneNews(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("sport.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    void alertError(String iphone) {
        Alert d = new Alert(Alert.AlertType.ERROR);
        d.setContentText(iphone);
        d.showAndWait();
    }
    @FXML

    public void onAdminLogin(ActionEvent event) throws Exception {
        if(specialCode.getText().equals("meow")){
            SwitchToSceneNews(event);
        }

        else{
            alertError("Not correct special code for Admins");
        }
        if (specialCode.getText().isBlank()) {
            specialCode.setStyle(errorStyle);

        }
    }
}
