package controller.customerController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dto.CustomerDTO;
import service.CustomerService;
import service.impl.CustomerServiceImpl;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerFormController implements Initializable {

    ObservableList<CustomerDTO> customerDTOS = FXCollections.observableArrayList();

    CustomerService customerService = new CustomerServiceImpl();


    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colCity;

    @FXML
    private TableColumn<?, ?> colCustomerID;

    @FXML
    private TableColumn<?, ?> colDOB;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPostalCode;

    @FXML
    private TableColumn<?, ?> colProvince;

    @FXML
    private TableColumn<?, ?> colSalary;

    @FXML
    private TableColumn<?, ?> colTitle;

    @FXML
    private TableView<CustomerDTO> tblCustomerInfo;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtCustomerID;

    @FXML
    private TextField txtDOB;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPostalCode;

    @FXML
    private TextField txtProvince;

    @FXML
    private TextField txtSalary;

    @FXML
    private TextField txtTitle;

    @FXML
    void btnAddOnAction(ActionEvent event) {

        String custID = txtCustomerID.getText();
        String custTitle = txtTitle.getText();
        String custName = txtName.getText();
        String dob = txtDOB.getText();
        double salary = Double.parseDouble(txtSalary.getText());
        String custAddress = txtAddress.getText();
        String city = txtCity.getText();
        String province = txtProvince.getText();
        String postalCode = txtPostalCode.getText();

        customerService.addCustomerDetails(custID, custTitle, custName, dob, salary, custAddress, city, province, postalCode);

        clearFields();
        loadCustomerDetails();

    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

        String CusIS = txtCustomerID.getText();
        customerService.deleteCustomerDetails(CusIS);

        loadCustomerDetails();
        clearFields();

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

        String custID = txtCustomerID.getText();
        String custTitle = txtTitle.getText();
        String custName = txtName.getText();
        String dob = txtDOB.getText();
        double salary = Double.parseDouble(txtSalary.getText());
        String custAddress = txtAddress.getText();
        String city = txtCity.getText();
        String province = txtProvince.getText();
        String postalCode = txtPostalCode.getText();

        customerService.updateCustomerDetails(custID, custTitle, custName, dob, salary, custAddress, city, province, postalCode);

        loadCustomerDetails();
        clearFields();

    }

    private void clearFields(){
        txtCustomerID.clear();
        txtTitle.clear();
        txtName.clear();
        txtDOB.clear();
        txtSalary.clear();
        txtAddress.clear();
        txtCity.clear();
        txtProvince.clear();
        txtPostalCode.clear();
    }

    private void loadCustomerDetails(){

        customerDTOS.clear();
        tblCustomerInfo.setItems(customerService.getAllCustomerDetails());

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colCustomerID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        colProvince.setCellValueFactory(new PropertyValueFactory<>("province"));
        colPostalCode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));

        loadCustomerDetails();

        tblCustomerInfo.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {

            if (newValue != null){

                txtCustomerID.setText(newValue.getId());
                txtTitle.setText(newValue.getTitle());
                txtName.setText(newValue.getName());
                txtDOB.setText(newValue.getDob());
                txtSalary.setText(String.valueOf(newValue.getSalary()));
                txtAddress.setText(newValue.getAddress());
                txtCity.setText(newValue.getCity());
                txtProvince.setText(newValue.getProvince());
                txtPostalCode.setText(newValue.getPostalCode());

            }

        } );

    }
}
