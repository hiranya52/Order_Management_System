package service.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.dto.ItemDTO;
import repository.ItemRepository;
import repository.impl.ItemRepositoryImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemServiceImpl implements ItemService {

    ItemRepository itemRepository = new ItemRepositoryImpl();

    @Override
    public void addItemDetails(String itemCode, String description, String PackSize, double unitPrice, int qtyOnHand) {

        try {
            itemRepository.addItem(itemCode,description,PackSize,unitPrice,qtyOnHand);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteItemDetails(String itemCode) {

    }

    @Override
    public void updateItemDetails(String itemCode, String description, String PackSize, double unitPrice, int qtyOnHand) {

    }

    @Override
    public ObservableList<ItemDTO> getAllItemDetails() {

        ObservableList<ItemDTO> itemDetails = FXCollections.observableArrayList();

        try {

            ResultSet resultSet = itemRepository.getAllItems();

            while (resultSet.next()){

                itemDetails.add(new ItemDTO(

                        resultSet.getString("ItemCode"),
                        resultSet.getString("Description"),
                        resultSet.getString("PackSize"),
                        resultSet.getDouble("UnitPrice"),
                        resultSet.getInt("QtyOnHand")

                ));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return itemDetails;


    }

}
