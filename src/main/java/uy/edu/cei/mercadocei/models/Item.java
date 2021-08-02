package uy.edu.cei.mercadocei.models;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Item implements Serializable {
    private Long id;
    private UUID uuid;
    private String name;
}
