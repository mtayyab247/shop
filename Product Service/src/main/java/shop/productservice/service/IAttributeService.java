package shop.productservice.service;

import shop.productservice.model.Attribute;
import shop.productservice.service.dto.NewAttributeDTO;
import shop.productservice.service.dto.NewCategoryDTO;

public interface IAttributeService {
    public NewAttributeDTO saveAttribute(NewAttributeDTO newAttributeDTO);
    public Attribute updateAttribute(Attribute attribute);
    public Attribute deleteAttribute(Attribute attribute);
}
