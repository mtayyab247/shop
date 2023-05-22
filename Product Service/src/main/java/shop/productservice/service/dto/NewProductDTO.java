package shop.productservice.service.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class NewProductDTO {
    private String name;
    private double price;
    private String description;
    private List<String> images = new ArrayList<>();
    private List<NewAttributeDTO> attributes = new ArrayList<>();
    private List<NewCategoryDTO> categories = new ArrayList<>();
    private int createdBy;
    private LocalDateTime createdDateTime = LocalDateTime.now();
    private LocalDateTime lastModified = LocalDateTime.now();
}
