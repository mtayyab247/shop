package shop.productservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.productservice.model.Category;
import shop.productservice.repository.CategoryRepository;
import shop.productservice.service.ICategoryService;
import shop.productservice.service.adapters.CategoryDTOAdapter;
import shop.productservice.service.dto.NewCategoryDTO;

@Service
public class CategoryService implements ICategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category getCategoryByName(String name) {
        return categoryRepository.getCategoryByName(name);
    }

    public NewCategoryDTO saveProductCategory(NewCategoryDTO newCategoryDTO) {
        Category category = new Category();
        category.setName(newCategoryDTO.getName());
        return CategoryDTOAdapter.getCategoryDTO(categoryRepository.save(category));
    }

    public Category updateProductCategory(Category category) {
        return null;
    }

    public Category deleteProductCategory(Category category) {
        return null;
    }
}
