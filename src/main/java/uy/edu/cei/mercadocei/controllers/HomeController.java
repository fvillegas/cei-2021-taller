package uy.edu.cei.mercadocei.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uy.edu.cei.mercadocei.mappers.ItemsMapper;
import uy.edu.cei.mercadocei.models.Item;

import java.util.List;

@RestController
@RequestMapping("/")
public class HomeController {

    private final ItemsMapper itemsMapper;

    @Autowired
    public HomeController(final ItemsMapper itemsMapper) {
        this.itemsMapper = itemsMapper;
    }

    @GetMapping
    public Item index() {
        return this.itemsMapper.selectById(1L);
    }

    @GetMapping("list")
    public List<Item> list() {
        return this.itemsMapper.selectAll();
    }

}
