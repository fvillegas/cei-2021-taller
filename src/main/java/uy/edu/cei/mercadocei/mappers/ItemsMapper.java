package uy.edu.cei.mercadocei.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import uy.edu.cei.mercadocei.models.Item;

import java.util.List;

@Mapper
public interface ItemsMapper {

    @Select("SELECT id, name FROM items WHERE id=#{id}")
    Item selectById(@Param("id") final Long id);

    @Select("SELECT id, name FROM items")
    List<Item> selectAll();
}
