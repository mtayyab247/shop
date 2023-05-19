package shop.productservice.model;

import jakarta.persistence.*;
import lombok.Data;
import shop.productservice.service.dto.NewAttributeValueDTO;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "attributes")
public class Attribute {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<AttributeValue> values = new ArrayList<>();
}
