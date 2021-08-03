package uy.edu.cei.mercadocei.common.messages;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uy.edu.cei.mercadocei.models.Item;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShoppingCartMessage {
    private Action action;
    private UUID userUUID;
    private Item item;
}
