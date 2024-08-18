package Controller;

import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Customer;

import java.util.List;

public class DeleteCustomerController {


    public Button btnExit;
    @FXML
    private TextField lblsearchfield;

    @FXML
    private Label lblID;

    @FXML
    private Label lblname;

    @FXML
    private Label lblcontact;

    @FXML
    private Label lbladdress;

    @FXML
    private Label lbldob;

    public void searchCustomer() {
        List<Customer> customerList = DBConnection.getInstance().getConnection();

        for (int i=0; i<customerList.size(); i++ ){
            Customer cus = customerList.get(i);

            if ((lblsearchfield.getText().equals(cus.getId()))||(lblsearchfield.getText().equals(cus.getName()))){
                lblID.setText(cus.getId());
                lblname.setText(cus.getName());
                lbladdress.setText(cus.getAddress());
                lblcontact.setText(cus.getContactNumber());
                lbldob.setText(String.valueOf(cus.getDob()));
            }
        }
    }


    public void btnsearch(ActionEvent actionEvent) {
        searchCustomer();
    }

    public void btndeleteonaction(ActionEvent actionEvent) {
        List<Customer> customerList = DBConnection.getInstance().getConnection();

        for (int i=0; i<customerList.size(); i++ ){
            Customer cus = customerList.get(i);

            if (lblsearchfield.getText().equals(cus.getId())){
                customerList.remove(cus);
            }
        }
    }


    public void btnClearonaction(ActionEvent actionEvent) {
        lblsearchfield.setText("");
        lblID.setText(" ");
        lblname.setText(" ");
        lbladdress.setText("");
        lblcontact.setText(" ");
        lbldob.setText("");
    }

    public void btnexitonaction(ActionEvent actionEvent) {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }
}
