package repository;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface CustomerRepository {

    void addCustomerDetails(String custID, String custTitle, String custName, String dob, double salary, String custAddress, String city, String province, String postalCode)  throws SQLException;

    void deleteCustomerDetails(String custID)  throws SQLException;

    void updateCustomerDetails(String custID, String custTitle, String custName, String dob, double salary, String custAddress, String city, String province, String postalCode)  throws SQLException;

    ResultSet viewCustomerDetails(String custID) throws SQLException;

    ResultSet getAllCustomerDetails() throws SQLException;

}
