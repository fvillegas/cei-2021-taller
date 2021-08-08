package uy.edu.cei.mercadocei.shoppingcart.components;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import uy.edu.cei.mercadocei.common.messages.Action;
import uy.edu.cei.mercadocei.common.messages.ShoppingCartMessage;
import uy.edu.cei.mercadocei.models.Item;
import uy.edu.cei.mercadocei.shoppingcart.mappers.ShoppingCartMapper;

import javax.jms.Session;
import java.util.UUID;

import static uy.edu.cei.mercadocei.configuration.ActiveMQConfig.SHOPPING_CART_QUEUE;


@Component
@Slf4j
@AllArgsConstructor
public class ShoppingCartConsumer {

    private final ShoppingCartMapper shoppingCartMapper;

    @JmsListener(destination = SHOPPING_CART_QUEUE)
    public void receiveMessage(@Payload ShoppingCartMessage payload) {
        log.info("shopping cart action: {}", payload);
        Item item = payload.getItem();
        UUID userUUID = payload.getUserUUID();
        if (payload.getAction() == Action.ADD_ITEM_TO_CART) {
            shoppingCartMapper.addItemToCart(userUUID, item);
        }
    }
}
