package uy.edu.cei.mercadocei.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uy.edu.cei.mercadocei.web.mappers.ItemsMapper;
import uy.edu.cei.mercadocei.common.models.Item;
import uy.edu.cei.mercadocei.web.services.ShoppingCartSender;

import java.util.List;
import java.util.UUID;

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

    @GetMapping("/{uuid}")
    public Item show(@PathVariable("uuid") final UUID uuid) {
        return this.itemsMapper.selectByUUID(uuid);
    }

    @PostMapping
    public Item create(@RequestBody final Item item) {
        item.setUuid(UUID.randomUUID());
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
