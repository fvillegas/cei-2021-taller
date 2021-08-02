package uy.edu.cei.mercadocei.common.messages;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Action {
    ADD_ITEM_TO_CART("add_item_to_cart"),
    REMOVE_ITEM_FROM_CART("remove_item_from_cart");
    private String value;
}
