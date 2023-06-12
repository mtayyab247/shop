package shop.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.productservice.model.Attribute;

@Repository
public interface AttributeRepository extends JpaRepository<Attribute, Integer> {

    public Attribute getAttributeByName(String name);
}
