package shop.productservice.service.adapters;

import shop.productservice.model.AttributeValue;
import shop.productservice.service.dto.NewAttributeValueDTO;

public class AttributeValueAdapter {

    public static AttributeValue getAttributeValue(NewAttributeValueDTO newAttributeValueDTO) {
        AttributeValue attributeValue = new AttributeValue();

        if(newAttributeValueDTO != null) {
            attributeValue.setValue(newAttributeValueDTO.getValue());
        }

        return attributeValue;
    }

    public static NewAttributeValueDTO getAttributeValueDTO(AttributeValue attributeValue) {
        NewAttributeValueDTO newAttributeValueDTO = new NewAttributeValueDTO();

        if(attributeValue != null) {
            newAttributeValueDTO.setValue(attributeValue.getValue());
        }

        return newAttributeValueDTO;
    }
}
