package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {

    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;

    @FXML
    void btnLogInOnAction(ActionEvent event) {

        String username =  txtUsername.getText();
        String password =  txtPassword.getText();

        if (username.equals("Admin") && password.equals("1234")){
            try {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/dashboard.fxml"));
                Scene scene = new Scene(loader.load());

                Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

                stage.setScene(scene);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else{
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Error");
            errorAlert.setHeaderText("Invalid User!");
            errorAlert.setContentText("Invalid username or password! Please enter the correct one.");
            errorAlert.showAndWait();
        }
    }

}
