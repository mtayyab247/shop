package shop.productservice.service;

import shop.productservice.model.Category;
import shop.productservice.service.dto.NewCategoryDTO;

public interface ICategoryService {
    public NewCategoryDTO saveProductCategory(NewCategoryDTO newCategoryDTO);
    public Category updateProductCategory(Category category);
    public Category deleteProductCategory(Category category);
}
