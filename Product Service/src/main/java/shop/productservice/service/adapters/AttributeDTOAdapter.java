package shop.productservice.service.adapters;

import lombok.Data;
import shop.productservice.model.Attribute;
import shop.productservice.model.AttributeValue;
import shop.productservice.service.dto.NewAttributeDTO;
import shop.productservice.service.dto.NewAttributeValueDTO;

import java.util.ArrayList;
import java.util.List;

@Data
public class AttributeDTOAdapter {
    public static Attribute getAttribute(NewAttributeDTO newAttributeDTO) {
        Attribute attribute = new Attribute();

        if(newAttributeDTO != null) {
            attribute.setName(newAttributeDTO.getName());
            List<AttributeValue> attributeValues = new ArrayList<>();

            for(NewAttributeValueDTO newAttributeValueDTO: newAttributeDTO.getValues()) {
                attributeValues.add(AttributeValueAdapter.getAttributeValue(newAttributeValueDTO));
            }

            attribute.setValues(attributeValues);
        }

        return attribute;
    }

    public static NewAttributeDTO getNewAttributeDTO(Attribute attribute) {
        NewAttributeDTO newAttributeDTO = new NewAttributeDTO();

        if(attribute != null) {
            newAttributeDTO.setName(attribute.getName());
            List<NewAttributeValueDTO> newAttributeValueDTOS = new ArrayList<>();

            for(AttributeValue attributeValue: attribute.getValues()) {
                newAttributeValueDTOS.add(AttributeValueAdapter.getAttributeValueDTO(attributeValue));
            }

            newAttributeDTO.setValues(newAttributeValueDTOS);
        }

        return newAttributeDTO;
    }
}
