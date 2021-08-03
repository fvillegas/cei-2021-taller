package uy.edu.cei.mercadocei.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uy.edu.cei.mercadocei.mappers.ItemsMapper;
import uy.edu.cei.mercadocei.models.Item;
import uy.edu.cei.mercadocei.services.ShoppingCartSender;

import java.util.List;

// esto es un bean y por defecto es singleton y NO PUEDE TENER ESTADO
@RestController
@RequestMapping("/items")
public class HomeController {

    private final ItemsMapper itemsMapper;
    private final ShoppingCartSender itemSender;

    @Autowired
    public HomeController(final ItemsMapper itemsMapper, ShoppingCartSender itemSender) {
        this.itemsMapper = itemsMapper;
        this.itemSender = itemSender;
    }

    @GetMapping
    public List<Item> index() {
        return this.itemsMapper.selectAll();
    }

    @GetMapping("/{id}")
    public Item show(@PathVariable("id") final Long id) {
        return this.itemsMapper.selectById(id);
    }

    @PostMapping
    public Item create(@RequestBody final Item item) {
        this.itemsMapper.create(item);
        return item;
    }

    @PutMapping("/{id}")
    public void update(
            @PathVariable("id") final Long id,
            @RequestBody final Item item) {
        final Item current = this.itemsMapper.selectById(id);
        if (item.getName() != null) {
            current.setName(item.getName());
        }
        this.itemsMapper.update(current);
    }

}
