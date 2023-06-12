package shop.productservice.service.impl;

import jakarta.persistence.EntityNotFoundException;
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

import java.util.Optional;


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

    public Category getCategoryByID(Integer id) {
        return categoryRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException()
        );
    }

    public Category getCategoryByName(String name) { return categoryRepository.getCategoryByName(name); }

    public NewCategoryDTO saveProductCategory(NewCategoryDTO newCategoryDTO) {
        return CategoryDTOAdapter.getCategoryDTO(categoryRepository.save(CategoryDTOAdapter.getCategory(newCategoryDTO)));
    }

    public Category updateProductCategory(Category category) {
        Category storedCategory = categoryRepository.findById(category.getId()).orElseThrow(
                () -> new EntityNotFoundException()
        );

        return categoryRepository.save(category);
    }

    public void deleteProductCategory(Integer id) {
        Category category = categoryRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException()
        );

        categoryRepository.delete(category);
    }
}
