package uy.edu.cei.mercadocei.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uy.edu.cei.mercadocei.common.messages.Action;
import uy.edu.cei.mercadocei.common.messages.ShoppingCartMessage;
import uy.edu.cei.mercadocei.models.Item;
import uy.edu.cei.mercadocei.services.ShoppingCartSender;

import java.util.UUID;

@RestController
@RequestMapping("/shopping-cart")
@AllArgsConstructor
public class ShoppingCartController {
    private final ShoppingCartSender shoppingCartSender;

    @PostMapping("/{user-uuid}")
    public void save(
            @PathVariable("user-uuid") final UUID userUUID,
            @RequestBody final Item item) {

        ShoppingCartMessage message = ShoppingCartMessage.builder()
                .action(Action.ADD_ITEM_TO_CART)
                .userUUID(userUUID)
                .item(item)
                .build();
        shoppingCartSender.send(message);
    }
}
