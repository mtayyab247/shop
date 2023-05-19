package shop.productservice.service.dto;

import lombok.Data;
import shop.productservice.model.AttributeValue;

import java.util.ArrayList;
import java.util.List;

@Data
public class AttributeDTO {
    private long id;
    private String name;
    private List<NewAttributeValueDTO> values = new ArrayList<>();
}
