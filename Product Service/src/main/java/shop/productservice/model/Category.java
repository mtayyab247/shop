package shop.productservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "product-category")
public class Category {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
}
