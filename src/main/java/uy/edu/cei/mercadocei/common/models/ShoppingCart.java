package uy.edu.cei.mercadocei.common.models;

import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ShoppingCart {
    private UUID userId;
    private UUID itemId;
}
