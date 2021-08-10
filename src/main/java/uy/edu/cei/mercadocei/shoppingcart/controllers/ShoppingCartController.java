package uy.edu.cei.mercadocei.shoppingcart.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uy.edu.cei.mercadocei.common.messages.Action;
import uy.edu.cei.mercadocei.common.messages.ShoppingCartMessage;
import uy.edu.cei.mercadocei.common.models.Item;
import uy.edu.cei.mercadocei.web.services.ShoppingCartSender;
import uy.edu.cei.mercadocei.shoppingcart.clients.IMSClient;
import uy.edu.cei.mercadocei.shoppingcart.mappers.ShoppingCartMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/shopping-cart")
@AllArgsConstructor
public class ShoppingCartController {
    private final ShoppingCartSender shoppingCartSender;
    private final ShoppingCartMapper shoppingCartMapper;
    private final IMSClient imsClient;

    @PostMapping("/{user-uuid}")
    public void save(
            @PathVariable("user-uuid") final UUID userUUID,
            @RequestBody final Item item) {

        final ShoppingCartMessage message = ShoppingCartMessage.builder()
                .action(Action.ADD_ITEM_TO_CART)
                .userUUID(userUUID)
                .item(item)
                .build();

        shoppingCartSender.send(message);
    }

    @GetMapping("/{user-uuid}")
    public List<Item> show() {
        final List<UUID> itemsUUIDs = this.shoppingCartMapper.getItemsFromCart();
        final List<Item> items = new ArrayList<>();

        for (UUID uuid: itemsUUIDs) {
            final Item item = this.imsClient.fetchItem(uuid);
            items.add(item);
        }

        return items;
    }
}
