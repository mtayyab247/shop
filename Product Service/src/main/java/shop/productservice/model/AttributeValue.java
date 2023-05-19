package shop.productservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "attribute_values")
public class AttributeValue {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String value;
}