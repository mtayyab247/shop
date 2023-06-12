package shop.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.productservice.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    public Category getCategoryByName(String name);
}
