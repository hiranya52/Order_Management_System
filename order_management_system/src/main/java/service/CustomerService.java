package service;

import javafx.collections.ObservableList;
import model.dto.CustomerDTO;

public interface CustomerService {

    void addCustomerDetails(String custID, String custTitle, String custName, String dob, double salary, String custAddress, String city, String province, String postalCode);

    void deleteCustomerDetails(String custID);

    void updateCustomerDetails(String custID, String custTitle, String custName, String dob, double salary, String custAddress, String city, String province, String postalCode);

    CustomerDTO viewCustomerDetails(String custID);

    ObservableList<CustomerDTO> getAllCustomerDetails();

}
