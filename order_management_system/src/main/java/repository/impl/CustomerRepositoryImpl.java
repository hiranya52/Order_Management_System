package repository.impl;

import repository.CustomerRepository;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRepositoryImpl implements CustomerRepository {


    @Override
    public void addCustomerDetails(String custID, String custTitle, String custName, String dob, double salary, String custAddress, String city, String province, String postalCode) throws SQLException {

    }

    @Override
    public void deleteCustomerDetails(String custID) throws SQLException {

    }

    @Override
    public void updateCustomerDetails(String custID, String custTitle, String custName, String dob, double salary, String custAddress, String city, String province, String postalCode) throws SQLException {

    }

    @Override
    public ResultSet viewCustomerDetails(String custID) throws SQLException {
        return null;
    }

    @Override
    public ResultSet getAllCustomerDetails() throws SQLException {
        return null;
    }
}
