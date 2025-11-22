package repository;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ItemRepository {

    void addItem(String itemCode, String description, String PackSize, double unitPrice, int qtyOnHand) throws SQLException;

    void deleteItem(String itemCode) throws SQLException;

    void updateItem(String itemCode, String description, String PackSize, double unitPrice, int qtyOnHand) throws SQLException;

    ResultSet getAllItems() throws SQLException;

}
