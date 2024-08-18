package Controller;



import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Customer;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class AddCustomerFormController implements Initializable {

    public Button btnExit;
    @FXML
    private ComboBox<String> cmbtitle;

    @FXML
    private TextField txtid;

    @FXML
    private TextField txtname;

    @FXML
    private TextField txtaddress;

    @FXML
    private DatePicker datepickerdob;

    @FXML
    private TextField txtcontact;


    private ObservableList<String> titleList = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> titles = FXCollections.observableArrayList();
        titles.add("Mr.");
        titles.add("Mrs.");

        cmbtitle.setItems(titles);
    }

    private void clearFields() {
        txtid.setText(null);
        txtname.setText(null);
        txtaddress.setText(null);
        cmbtitle.setItems(titleList);
        txtcontact.setText(null);
        datepickerdob.setValue(null);
    }


    public void btnaddonaction(ActionEvent actionEvent) {

        System.out.println(new Customer(txtid.getText(), cmbtitle.getValue(), txtname.getText(), txtaddress.getText(), txtcontact.getText(),datepickerdob.getValue()));

        List<Customer> customerList = DBConnection.getInstance().getConnection();

        customerList.add(new Customer(txtid.getText(), cmbtitle.getValue(), txtname.getText(), txtaddress.getText(), txtcontact.getText(),datepickerdob.getValue()));

        clearFields();
    }


    public void btnexitonaction(ActionEvent actionEvent) {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }
}

