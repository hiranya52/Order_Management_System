package repository.impl;

import db.DBConnection;
import repository.CustomerRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRepositoryImpl implements CustomerRepository {


    @Override
    public void addCustomerDetails(String custID, String custTitle, String custName, String dob, double salary, String custAddress, String city, String province, String postalCode) throws SQLException {

        try {
            Connection connection = DBConnection.getInstance().getConnection();

            String SQL = "INSERT INTO customer VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setObject(1, custID);
            preparedStatement.setObject(2, custTitle);
            preparedStatement.setObject(3, custName);
            preparedStatement.setObject(4, dob);
            preparedStatement.setObject(5, salary);
            preparedStatement.setObject(6, custAddress);
            preparedStatement.setObject(7, city);
            preparedStatement.setObject(8, province);
            preparedStatement.setObject(9, postalCode);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteCustomerDetails(String custID) throws SQLException {

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement("DELETE FROM customer WHERE CustID = ?");

            pstm.setObject(1, custID);
            pstm.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateCustomerDetails(String custID, String custTitle, String custName, String dob, double salary, String custAddress, String city, String province, String postalCode) throws SQLException {

        try {
            Connection connection = DBConnection.getInstance().getConnection();

            String SQL = "UPDATE customer SET CustTitle = ?, CustName = ?, DOB = ?, salary = ?, CustAddress = ?, City = ?, Province = ?, PostalCode = ? WHERE CustID = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setObject(1, custTitle);
            preparedStatement.setObject(2, custName);
            preparedStatement.setObject(3, dob);
            preparedStatement.setObject(4, salary);
            preparedStatement.setObject(5, custAddress);
            preparedStatement.setObject(6, city);
            preparedStatement.setObject(7, province);
            preparedStatement.setObject(8, postalCode);
            preparedStatement.setObject(9, custID);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public ResultSet viewCustomerDetails(String custID) throws SQLException {
        return null;
    }

    @Override
    public ResultSet getAllCustomerDetails() throws SQLException {

        Connection connection = DBConnection.getInstance().getConnection();
        String SQL = "SELECT * FROM Customer";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);

        return preparedStatement.executeQuery();

    }
}
