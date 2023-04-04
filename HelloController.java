package com.example.demo4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController {
    private Stage stage;
    private Scene scene;
    private Parent parent;

    protected String successMessage = String.format("-fx-text-fill: GREEN;");
    String errorMessage = String.format("-fx-text-fill: RED;");
    String errorStyle = String.format("-fx-border-color: RED; -fx-border-width: 2; -fx-border-radius: 5;");
    String successStyle = String.format("-fx-border-color: #A9A9A9; -fx-border-width: 2; -fx-border-radius: 5;");

    @FXML
    private Label invalidLoginCredentials;
    @FXML
    private CheckBox checkBox;
    @FXML
    private Label invalidSignupCredentials;
    @FXML
    private Button cancelButton;
    @FXML
    private TextField loginUsernameTextField;
    @FXML
    private TextField loginPasswordPasswordField;

    @FXML
    private Button loginButton;
    static boolean toCheck;

    @FXML
    protected void onCancelButtonClick() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    File f = new File("myFolder");
    String Username, Password, Email;
    int ln;

    void createFolder() {
        if (!f.exists()) {
            f.mkdirs();
        }
    }

    void readFile() throws FileNotFoundException {
        try {
            FileReader fr = new FileReader("myFolder/file.txt");
            System.err.println("file exist");
        } catch (FileNotFoundException e) {
            try {
                FileWriter fw = new FileWriter("myFolder/file.txt");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }


    void checkData(String usr, String psw, String email) {
        try {
            RandomAccessFile f = new RandomAccessFile("myFolder/file.txt", "rw");
            String line = f.readLine();
            Username = "Username:" + line;
            Password = "Password:" + f.readLine();
            Email = "Email:" + f.readLine();
            usr = "Username:" + usr;
            psw = "Password:" + psw;
            System.out.println(Username);
            System.out.println(usr);
            if (usr.equals(Username) & psw.equals(Password)) {
                alertError("Password Matched");
            } else {
                alertError("Wrong Password/Username");

            }
            if (usr.length() >= 9 || psw.length() >= 9 || email.length() >= 9) {
                alertError("Password/Username must be less than 9 character");
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    void countLines() {
        try {
            ln = 1;
            RandomAccessFile f = new RandomAccessFile("myFolder/file.txt", "rw");
            for (int i = 0; f.readLine() != null; i++) {
                ln++;

            }
            System.out.println("Number of lines: " + ln);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    boolean logic(String usr, String psw) {
        try {
            RandomAccessFile f = new RandomAccessFile("myFolder/file.txt", "rw");
            for (int i = 0; i < ln; i += 3) {
                String forUser = f.readLine();
                String forPsw = f.readLine();
                if (("Username:" + usr).equals(forUser) && ("Password:" + psw).equals(forPsw)) {
                    return true;
                } else if (i == (ln - 2)) {


                }
                for (int j = 1; j <= 2; j++) {
                    f.readLine();

                }


            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }


    @FXML
    protected void onLoginButtonClick(ActionEvent event) throws Exception {
        if (toCheck && loginUsernameTextField.getText().isEmpty() &&  loginPasswordPasswordField.getText().isEmpty()) {
            SwitchToSceneNews(event);
        } else {
            createFolder();
            readFile();
            countLines();
            if (logic(loginUsernameTextField.getText(), loginPasswordPasswordField.getText())) {
                SwitchToSceneNews(event);
            }
          else if (loginUsernameTextField.getText().isEmpty() || loginPasswordPasswordField.getText().isEmpty()) {
                invalidLoginCredentials.setText("The Login fields are required!");
                invalidLoginCredentials.setStyle(errorMessage);
                invalidSignupCredentials.setText("");
            }

            if (loginUsernameTextField.getText().isBlank()) {
                loginUsernameTextField.setStyle(errorStyle);
            } else if (loginPasswordPasswordField.getText().isBlank()) {
                loginPasswordPasswordField.setStyle(errorStyle);
            }
            else if(!(logic(loginUsernameTextField.getText(), loginPasswordPasswordField.getText()))){
                alertError("Wrong Password/Username");
            }
        }
    }


    public void SwitchToScene2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("sign-up.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void SwitchToSceneAdmin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("admin.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void SwitchToSceneNews(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("sport.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void SwitchToSceneForgotPassword(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("forgotPassword.fxml"));
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

    void alertSuccess(String android) {
        Alert d = new Alert(Alert.AlertType.INFORMATION);
        d.setContentText(android);
        d.showAndWait();
    }

    @FXML
    private void checkBox(ActionEvent event){
        if(checkBox.isSelected()){
             toCheck = true;
        }
    }


}