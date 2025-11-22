package service.impl;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.dto.CustomerDTO;
import repository.CustomerRepository;
import repository.impl.CustomerRepositoryImpl;
import service.CustomerService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerServiceImpl implements CustomerService {

    CustomerRepository customerRepository = new CustomerRepositoryImpl();

    @Override
    public void addCustomerDetails(String custID, String custTitle, String custName, String dob, double salary, String custAddress, String city, String province, String postalCode) {
        try {
            customerRepository.addCustomerDetails(custID, custTitle, custName, dob, salary, custAddress, city, province, postalCode);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteCustomerDetails(String custID) {

        try {
            customerRepository.deleteCustomerDetails(custID);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateCustomerDetails(String custID, String custTitle, String custName, String dob, double salary, String custAddress, String city, String province, String postalCode) {

    }

    @Override
    public CustomerDTO viewCustomerDetails(String custID) {
        return null;
    }

    @Override
    public ObservableList<CustomerDTO> getAllCustomerDetails() {

        ObservableList<CustomerDTO> customerDetails = javafx.collections.FXCollections.observableArrayList();

        try {

            ResultSet resultSet = customerRepository.getAllCustomerDetails();

            while (resultSet.next()){
                customerDetails.add(new CustomerDTO(
                        resultSet.getString("CustID"),
                        resultSet.getString("CustTitle"),
                        resultSet.getString("CustName"),
                        resultSet.getString("DOB"),
                        resultSet.getDouble("salary"),
                        resultSet.getString("CustAddress"),
                        resultSet.getString("City"),
                        resultSet.getString("Province"),
                        resultSet.getString("PostalCode")
                ));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customerDetails;
    }
}
