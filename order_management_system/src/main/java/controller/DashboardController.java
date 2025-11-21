package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardController {

    @FXML
    void btnCustomerInfoOnAction(ActionEvent event) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/customer_info.fxml"));
            Scene scene = new Scene(loader.load());

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

            stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnItemInfoOnAction(ActionEvent event) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/item_info.fxml"));
            Scene scene = new Scene(loader.load());

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

            stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnOrderDetailsOnAction(ActionEvent event) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/order_details.fxml"));
            Scene scene = new Scene(loader.load());

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

            stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnOrdersInfoOnAction(ActionEvent event) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/orders_info.fxml"));
            Scene scene = new Scene(loader.load());

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

            stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
