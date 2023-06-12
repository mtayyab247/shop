package shop.productservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    public Page<Category> listCategories(int pageNumber, int pageSize) {
        Pageable pageable = (Pageable) PageRequest.of(pageNumber, pageSize);
        return categoryRepository.findAll(pageable);
    }

    public Category getCategoryByID() {
        return null;
    }

    public Category getCategoryByName(String name) { return categoryRepository.getCategoryByName(name); }

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
