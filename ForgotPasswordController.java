package com.example.demo4;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ForgotPasswordController {
    protected String successMessage = String.format("-fx-text-fill: GREEN;");
    String errorMessage = String.format("-fx-text-fill: RED;");
    String errorStyle = String.format("-fx-border-color: RED; -fx-border-width: 2; -fx-border-radius: 5;");
    String successStyle = String.format("-fx-border-color: #A9A9A9; -fx-border-width: 2; -fx-border-radius: 5;");
    private Stage stage;
    private Scene scene;
    private Parent parent;


    @FXML
    private Button cancelButton;
    @FXML
    private TextField EmailFP;


    @FXML
    private Label invalidLoginCredentials;

    @FXML
    private Label invalidSignupCredentials;


    @FXML
    private TextField usernameFP;

    @FXML
    private PasswordField forgetFP;
    @FXML
    private TextField emailFP;


    @FXML
    protected void onCancelButtonClick() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
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

    @FXML
    void onChangeButtonClick(ActionEvent event) throws FileNotFoundException {
        countLines();
        boolean passwordChanged = NewPassword(usernameFP.getText());
        if (!passwordChanged) {
            alertError("No User in system such this");
        } else if(passwordChanged) {
            addData(usernameFP.getText(), forgetFP.getText(), emailFP.getText());
            alertSuccess("Successfully changed Password");
        } else if (usernameFP.getText().isBlank() || forgetFP.getText().isBlank()) {
            invalidLoginCredentials.setText("The Login fields are required!");
            invalidLoginCredentials.setStyle(errorMessage);
            invalidSignupCredentials.setText("");
            if (usernameFP.getText().isBlank()) {
                usernameFP.setStyle(errorStyle);
            } else if (forgetFP.getText().isBlank()) {
                forgetFP.setStyle(errorStyle);
            }
        }

    }

    void addData(String usr, String psw, String email) throws FileNotFoundException {

        try {
            RandomAccessFile f = new RandomAccessFile("myFolder/file.txt", "rw");
            for (int i = 0; i < ln; i++) {
                f.readLine();
            }
//            f.writeBytes("\r\n");
            f.writeBytes("\r\n");
            f.writeBytes("Username:" + usr + "\r\n");
            f.writeBytes("Password:" + psw + "\r\n");
            f.writeBytes("Email:" + email + "\r\n");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    int ln;

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

    boolean NewPassword(String usernameToDelete) {
        try {
            final String filename = "myFolder/file.txt";

            List<String> lines = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
            } catch (FileNotFoundException e) {
                System.err.println("File not found");
                e.printStackTrace();
                return false;
            } catch (IOException e) {
                System.err.println("Error reading file");
                e.printStackTrace();
                return false;
            }

            // Modify the contents of the list to remove the data for the specified username
            List<String> modifiedLines = new ArrayList<>();
            boolean deleteNextLine = false;
            boolean skipEmailLine = false;
            boolean userFound = false; // flag to indicate whether the user was found
            for (String line : lines) {
                if (skipEmailLine) {
                    // Skip the line that contains email
                    skipEmailLine = false;
                    continue;
                } else if (deleteNextLine) {
                    // Skip the line that contains the password
                    deleteNextLine = false;
                    skipEmailLine = true;
                    continue;
                } else if (line.startsWith("Username:") && ("Username:" + usernameToDelete).equals(line)) {
                    // Skip the line that contains the username and mark the next line for deletion
                    deleteNextLine = true;
                    skipEmailLine = true;
                    userFound = true;
                    continue;
                } else {
                    // Add the line to the modified list
                    modifiedLines.add(line);
                }
            }

            if (!userFound) {
                return false; // user not found in file
            }

            // Write the modified contents back to the file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
                for (String line : modifiedLines) {
                    writer.write(line);
                    writer.newLine();
                }
            } catch (IOException e) {
                System.err.println("Error writing file");
                e.printStackTrace();
                return false;
            }

            return true;

        } catch (Exception ex) {
            System.err.println("Error deleting user data");
            ex.printStackTrace();
            return false;
        }
    }


//    public static void changePassword(String filename, String oldPassword, String newPassword) {
//        List<String> lines = new ArrayList<>();
//        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] parts = line.split(":");
//                if (parts.length == 2 && parts[0].equals("Password") && parts[1].equals(oldPassword)) {
//                    lines.add("Password:" + newPassword);
//                } else {
//                    lines.add(line);
//                }
//            }
//        } catch (FileNotFoundException e) {
//            System.err.println("Error: file not found");
//            e.printStackTrace();
//            return;
//        } catch (IOException e) {
//            System.err.println("Error: IOException");
//            e.printStackTrace();
//            return;
//        }
//
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
//            for (String line : lines) {
//                writer.write(line);
//                writer.newLine();
//            }
//        } catch (IOException e) {
//            System.err.println("Error writing to file");
//            e.printStackTrace();
//        }
//    }


}





