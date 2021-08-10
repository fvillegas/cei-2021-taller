package uy.edu.cei.mercadocei.shoppingcart.mappers;

import org.apache.ibatis.annotations.*;
import uy.edu.cei.mercadocei.common.models.Item;

import java.util.List;
import java.util.UUID;

@Mapper
public interface ShoppingCartMapper {
    @Insert("INSERT INTO shopping_cart VALUES(#{user}, #{item.uuid}, false)")
    public void addItemToCart(@Param("user") final UUID userUUID, @Param("item") final Item item);

    @Select("SELECT item_id FROM shopping_cart")
    public List<UUID> getItemsFromCart();
}
