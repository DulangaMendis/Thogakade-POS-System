package Controller;

import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Customer;

import java.time.LocalDate;
import java.util.List;

public class UpdateCustomerController {

    @FXML
    private Label lblID;

    @FXML
    private TextField txtname;

    @FXML
    private TextField txtaddress;

    @FXML
    private TextField txtcontact;

    @FXML
    private TextField txtdob;


    @FXML
    private Button btnExit;

    @FXML
    private TextField lblsearchfield;






    public void btnExitonaction(ActionEvent actionEvent) {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }

    public void btnclearonaction(ActionEvent actionEvent) {
        lblsearchfield.setText("");
        lblID.setText(" ");
        txtname.setText(" ");
        txtaddress.setText("");
        txtcontact.setText(" ");
        txtdob.setText("");
    }
    private void searchCustomer() {
        List<Customer> customerList = DBConnection.getInstance().getConnection();

        for (int i=0; i<customerList.size(); i++ ){
            Customer cus = customerList.get(i);

            if ((lblsearchfield.getText().equals(cus.getId()))||(lblsearchfield.getText().equals(cus.getName()))){
                lblID.setText(cus.getId());
                txtname.setText(cus.getName());
                txtaddress.setText(cus.getAddress());
                txtcontact.setText(cus.getContactNumber());
                txtdob.setText(String.valueOf(cus.getDob()));
            }
        }
    }


    public void btnsearch(ActionEvent actionEvent) {
        searchCustomer();
    }

    public void updateCustomer(String name, String newName, String newAddress, String newContact, LocalDate newDob) {
        List<Customer> customerList = DBConnection.getInstance().getConnection();
        for (int i=0; i<customerList.size(); i++) {
            Customer cus = customerList.get(i);
            if (cus.getName().equals(name)) {
                cus.setName(newName);
                cus.setAddress(newAddress);
                cus.setContactNumber(newContact);
                cus.setDob(newDob);
                break; // Exit the loop after finding the customer
            }
        }
    }

    private void clearFields(){
        lblID.setText(null);
        txtname.setText(null);
        txtaddress.setText(null);
        txtcontact.setText(null);
        txtdob.setText(null);
    }


    public void btnupdateonaction(ActionEvent actionEvent) {
        List<Customer> customerList = DBConnection.getInstance().getConnection();

       // customerList.add(new Customer(lblID.getText(), txtname.getText(), txtaddress.getText(), txtcontact.getText()));

        clearFields();







    }
}

