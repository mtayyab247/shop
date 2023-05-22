package shop.productservice.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "product")
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private double price;
    private String description;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> images = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "product_attributes",
        joinColumns = {@JoinColumn(name = "product_id")},
        inverseJoinColumns = {@JoinColumn(name = "attribute_id")}
    )
    private List<Attribute> attributes = new ArrayList<Attribute>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "product_categories",
        joinColumns = { @JoinColumn(name = "product_id")},
        inverseJoinColumns = {@JoinColumn( name = "category_id")}
    )
    private List<Category> categories = new ArrayList<>();

    //    @CreatedBy
    private int createdBy; // adminid

    @CreatedDate
    private LocalDateTime createdDateTime = LocalDateTime.now();

    @LastModifiedDate
    private LocalDateTime lastModified = LocalDateTime.now();

}
