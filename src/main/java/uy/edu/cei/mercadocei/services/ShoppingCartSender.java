package uy.edu.cei.mercadocei.services;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import uy.edu.cei.mercadocei.common.messages.ShoppingCartMessage;

import static uy.edu.cei.mercadocei.configuration.ActiveMQConfig.SHOPPING_CART_QUEUE;

@Slf4j
@Service
@AllArgsConstructor
public class ShoppingCartSender {

    private final JmsTemplate jmsTemplate;

    public void send(ShoppingCartMessage message) {
        if (log.isInfoEnabled()) {
            log.info("message: {}", message);
        }
        jmsTemplate.convertAndSend(SHOPPING_CART_QUEUE, message);
    }
}
