package service.impl;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.dto.CustomerDTO;
import service.CustomerService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerServiceImpl implements CustomerService {


    @Override
    public void addCustomerDetails(String custID, String custTitle, String custName, String dob, double salary, String custAddress, String city, String province, String postalCode) {

    }

    @Override
    public void deleteCustomerDetails(String custID) {

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

        ObservableList<CustomerDTO> customerDTOS = FXCollections.observableArrayList();

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String SQL = "SELECT * FROM Customer";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();

            customerDTOS.add(new CustomerDTO(

                    resultSet.getString("CustID"),
                    resultSet.getString("CustTitle"),
                    resultSet.getString("CustName"),
                    resultSet.getString("DOB"),
                    resultSet.getDouble("salary"),
                    resultSet.getString("CustAddress"),
                    resultSet.getString("City"),
                    resultSet.getString("Pronvice"),
                    resultSet.getString("PostalCode")

            ));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return customerDTOS;

    }
}
