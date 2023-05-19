package shop.productservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import shop.productservice.model.Attribute;

@Repository
public interface AttributeRepository extends CrudRepository<Attribute, Integer> {

    public Attribute getAttributeByName(String name);
}
