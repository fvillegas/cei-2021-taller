package uy.edu.cei.mercadocei.mappers;

import org.apache.ibatis.annotations.*;
import uy.edu.cei.mercadocei.models.Item;

import java.util.List;
import java.util.UUID;

@Mapper
public interface ItemsMapper {

    @Select("SELECT id, name FROM items WHERE id=#{id}")
    Item selectById(@Param("id") final Long id);

    @Select("SELECT id, uuid, name FROM items")
    List<Item> selectAll();

    @SelectKey(
            statement = "SELECT nextval('items_sq')",
            keyProperty = "item.id",
            before = true,
            resultType = Long.class)
    @Insert("INSERT INTO items VALUES(#{item.id}, #{item.name})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int create(@Param("item") Item item);

    @Update("UPDATE items SET name=#{item.name} WHERE id=#{item.id}")
    void update(@Param("item") Item item);

    @Select("SELECT id, uuid, name FROM items WHERE uuid=#{uuid}")
    Item selectByUUID(@Param("uuid") UUID uuid);
}
