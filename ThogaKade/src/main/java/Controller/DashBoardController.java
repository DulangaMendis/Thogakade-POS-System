package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DashBoardController {
    public void btnaddcustomeronaction(ActionEvent actionEvent) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/add_customer_form.fxml"))));
            stage.show();
            stage.setTitle("Add Customers");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnsearchcustomeronaction(ActionEvent actionEvent) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/search_customer.fxml"))));
            stage.show();
            stage.setTitle("Search Customers");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void btnupdatecustomeronaction(ActionEvent actionEvent) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/update_customer.fxml"))));
            stage.show();
            stage.setTitle("Upadete Customers");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void btndeletecustomeronaction(ActionEvent actionEvent) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/delete_customer.fxml"))));
            stage.show();
            stage.setTitle("Delete Customers");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnviewcustomersonaction(ActionEvent actionEvent) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/view_customer.fxml"))));
            stage.show();
            stage.setTitle("View Customers");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
