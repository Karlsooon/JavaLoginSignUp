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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;

public class SignUpController {
    private Stage stage;
    private Scene scene;
    private Parent parent;


    protected
    String successMessage = String.format("-fx-text-fill: GREEN;");
    String errorMessage = String.format("-fx-text-fill: RED;");
    String errorStyle = String.format("-fx-border-color: RED; -fx-border-width: 2; -fx-border-radius: 5;");
    String successStyle = String.format("-fx-border-color: #A9A9A9; -fx-border-width: 2; -fx-border-radius: 5;");

    @FXML
    private Label invalidLoginCredentials;

    @FXML
    private Label invalidSignupCredentials;
    @FXML
    private Button cancelButton;
    @FXML
    private TextField signUpUsernameTextField;
    @FXML
    private TextField signUpEmailTextField;

    @FXML
    private TextField signUpPasswordPasswordField;
    @FXML
    private TextField signUpRepeatPasswordPasswordField;

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
            System.out.println("File Created");
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


    void addData(String usr, String psw, String mail) throws FileNotFoundException {

        try {
            RandomAccessFile f = new RandomAccessFile("myFolder/file.txt", "rw");
            for (int i = 0; i < ln; i++) {
                f.readLine();
            }

//            f.writeBytes("\r\n");
            f.writeBytes("Username:" + usr + "\r\n");
            f.writeBytes("Password:" + psw + "\r\n");
            f.writeBytes("Email:" + mail+"\r\n");
            f.writeBytes("\r\n");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    int checkData(String usr, String psw) {
        int res = 0;
        try {
            RandomAccessFile f = new RandomAccessFile("myFolder/file.txt", "rw");
            for (int i = 0; i < ln; i += 3) {
                String forUser = f.readLine();
                String forPsw = f.readLine();
                if (("Username:" + usr).equals(forUser)) {
                    res = 1;
                }
                if (usr.length() >= 9 || psw.length() >= 9) {
                    res = 2;
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
        return res;
    }


    void countLines() {
        try {
            ln = 1;
            RandomAccessFile f = new RandomAccessFile("myFolder/file.txt", "rw");
            for (int i = 0; f.readLine() != null; i++) {
                ln++;

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @FXML
    void onSignUpButtonClick(ActionEvent event) throws FileNotFoundException {
        {
            createFolder();
            readFile();
            countLines();
            if (signUpUsernameTextField.getText().isBlank() || signUpEmailTextField.getText().isBlank() || signUpPasswordPasswordField.getText().isBlank() ) {
                invalidSignupCredentials.setText("Please fill in all fields!");
                invalidSignupCredentials.setStyle(errorMessage);
//                invalidLoginCredentials.setText("");

                if (signUpUsernameTextField.getText().isBlank()) {
                    signUpUsernameTextField.setStyle(errorStyle);
                } else if (signUpEmailTextField.getText().isBlank()) {
                    signUpEmailTextField.setStyle(errorStyle);
                } else if (signUpPasswordPasswordField.getText().isBlank()) {
                    signUpPasswordPasswordField.setStyle(errorStyle);
                } else if (signUpRepeatPasswordPasswordField.getText().isBlank()) {
                    signUpRepeatPasswordPasswordField.setStyle(errorStyle);
                }
            }

            if (checkData(signUpUsernameTextField.getText(), signUpPasswordPasswordField.getText()) == 1) {
                alertError("That user already exists in the system");
            } else if (checkData(signUpUsernameTextField.getText(), signUpPasswordPasswordField.getText()) == 2) {
                alertError("Password/Username/Email must be less than 9 characters");
            }
            if (checkData(signUpUsernameTextField.getText(), signUpPasswordPasswordField.getText()) == 0) {
                addData(signUpUsernameTextField.getText(), signUpPasswordPasswordField.getText(), signUpEmailTextField.getText());
                alertSuccess("Account successfully created");
            }


        }
    }

    public void SwitchToScene1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
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
}



