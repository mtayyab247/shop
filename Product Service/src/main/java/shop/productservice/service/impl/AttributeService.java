package shop.productservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.productservice.model.Attribute;
import shop.productservice.repository.AttributeRepository;
import shop.productservice.service.IAttributeService;
import shop.productservice.service.dto.NewAttributeDTO;
import shop.productservice.service.dto.NewCategoryDTO;

import java.util.List;

@Service
public class AttributeService implements IAttributeService {

    private AttributeRepository attributeRepository;

    @Autowired
    public AttributeService(AttributeRepository attributeRepository) {
        this.attributeRepository = attributeRepository;
    }

    public List<Attribute> listAttributes() {
        return (List<Attribute>) attributeRepository.findAll();
    }

    public Attribute getAttributeById() {
        return null;
    }

    public Attribute getAttributeByName(String name) {
        return attributeRepository.getAttributeByName(name);
    }

    public NewAttributeDTO saveAttribute(NewAttributeDTO newAttributeDTO) {
        Attribute attribute = new Attribute();

        attribute.setName(newAttributeDTO.getName());

        return null;
    }

    public Attribute updateAttribute(Attribute attribute) {
        return null;
    }

    public Attribute deleteAttribute(Attribute attribute) {
        return null;
    }
}
