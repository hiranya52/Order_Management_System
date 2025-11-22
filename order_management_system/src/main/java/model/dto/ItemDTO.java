package model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ItemDTO {

    private String itemCode;

    private String description;

    private String PackSize;

    private double unitPrice;

    private int qtyOnHand;

}
