package shop.productservice.service.adapters;

import lombok.Data;
import shop.productservice.model.Category;
import shop.productservice.service.dto.NewCategoryDTO;

@Data
public class CategoryDTOAdapter {

    public static Category getCategory(NewCategoryDTO newCategoryDTO) {
        Category category = new Category();

        if(newCategoryDTO != null) {
            category.setName(newCategoryDTO.getName());
        }

        return category;
    }

    public static NewCategoryDTO getCategoryDTO(Category category) {
        NewCategoryDTO newCategoryDTO = new NewCategoryDTO();

        if(newCategoryDTO != null) {
            newCategoryDTO.setName(category.getName());
        }

        return newCategoryDTO;
    }
}
