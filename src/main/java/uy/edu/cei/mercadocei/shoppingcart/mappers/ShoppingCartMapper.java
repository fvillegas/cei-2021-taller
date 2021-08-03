package uy.edu.cei.mercadocei.shoppingcart.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import uy.edu.cei.mercadocei.models.Item;

import java.util.UUID;

@Mapper
public interface ShoppingCartMapper {
    @Insert("INSERT INTO shopping_cart VALUES(#{user}, #{item.id}, false)")
    public void addItemToCart(@Param("user") final UUID userUUID, @Param("item") final Item item);
}
