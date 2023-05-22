package shop.productservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import shop.productservice.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
