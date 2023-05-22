package shop.productservice.repository;

import org.springframework.data.repository.CrudRepository;
import shop.productservice.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

    public Category getCategoryByName(String name);
}
