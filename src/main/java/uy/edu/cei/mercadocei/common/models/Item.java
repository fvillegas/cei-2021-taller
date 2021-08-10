package uy.edu.cei.mercadocei.common.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Item implements Serializable {
    @JsonIgnore
    private Long id;
    private UUID uuid;
    private String name;
}
