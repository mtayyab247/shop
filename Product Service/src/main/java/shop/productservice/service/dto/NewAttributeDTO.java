package shop.productservice.service.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class NewAttributeDTO {
    private String name;
    private List<NewAttributeValueDTO> values = new ArrayList<>();
}
