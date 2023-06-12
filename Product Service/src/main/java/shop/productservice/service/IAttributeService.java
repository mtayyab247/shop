package shop.productservice.service;

import shop.productservice.model.Attribute;
import shop.productservice.service.dto.NewAttributeDTO;
import shop.productservice.service.dto.NewCategoryDTO;

import java.util.List;

public interface IAttributeService {
    public List<Attribute> listAttributes();
    public Attribute getAttributeById();
    public Attribute getAttributeByName(String name);
    public NewAttributeDTO saveAttribute(NewAttributeDTO newAttributeDTO);
    public Attribute updateAttribute(Attribute attribute);
    public Attribute deleteAttribute(Attribute attribute);
}
