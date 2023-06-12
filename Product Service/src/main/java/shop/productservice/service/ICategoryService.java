package shop.productservice.service;

import org.springframework.data.domain.Page;
import shop.productservice.model.Category;
import shop.productservice.service.dto.NewCategoryDTO;

import java.util.List;

public interface ICategoryService {
    public Page<Category> listCategories(int pageNumber, int pageSize);
    public Category getCategoryByID(Integer id);
    public Category getCategoryByName(String name);
    public NewCategoryDTO saveProductCategory(NewCategoryDTO newCategoryDTO);
    public Category updateProductCategory(Category category);
    public void deleteProductCategory(Integer integer);
}
