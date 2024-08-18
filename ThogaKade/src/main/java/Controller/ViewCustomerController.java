package Controller;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Customer;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ViewCustomerController implements Initializable {

    @FXML
    private TableView<Customer> tblviewcustomers;

    @FXML
    private TableColumn<?, ?> colid;

    @FXML
    private TableColumn<?, ?> colname;

    @FXML
    private TableColumn<?, ?> coladdress;

    @FXML
    private TableColumn<?, ?> colcontact;

    @FXML
    private TableColumn<?, ?> coldob;

    @FXML
    private Button btnExit;

    private void loadTable(){
        List<Customer> customerList = DBConnection.getInstance().getConnection();
        ObservableList<Customer> customerObservableList = FXCollections.observableArrayList();

        customerList.forEach(obj->{
            customerObservableList.add(obj);
        });

        tblviewcustomers.setItems(customerObservableList);

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colid.setCellValueFactory(new PropertyValueFactory<>("id"));
        colname.setCellValueFactory(new PropertyValueFactory<>("name"));
        coladdress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colcontact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        coldob.setCellValueFactory(new PropertyValueFactory<>("dob"));

        loadTable();

    }

    public void btnreloadonaction(ActionEvent actionEvent) {
        loadTable();
    }

    public void btnexitonaction(ActionEvent actionEvent) {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }
}

