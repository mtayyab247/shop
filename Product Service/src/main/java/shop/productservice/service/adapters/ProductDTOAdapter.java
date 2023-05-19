package shop.productservice.service.adapters;

import shop.productservice.model.Attribute;
import shop.productservice.model.Category;
import shop.productservice.model.Product;
import shop.productservice.service.dto.NewAttributeDTO;
import shop.productservice.service.dto.NewCategoryDTO;
import shop.productservice.service.dto.NewProductDTO;

import java.util.ArrayList;
import java.util.List;

public class ProductDTOAdapter {
    public static Product getProduct(NewProductDTO newProductDTO) {
        Product product = new Product();

        if(newProductDTO != null) {
            product.setName(newProductDTO.getName());
            product.setPrice(newProductDTO.getPrice());
            product.setDescription(newProductDTO.getDescription());
            product.setImages(newProductDTO.getImages());

            List<Attribute> attributes = new ArrayList<>();

            for(NewAttributeDTO newAttributeDTO: newProductDTO.getAttributes()) {
                attributes.add(AttributeDTOAdapter.getAttribute(newAttributeDTO));
            }

            product.setAttributes(attributes);

            List<Category> categories = new ArrayList<>();

            for(NewCategoryDTO newCategoryDTO: newProductDTO.getCategories()) {
                categories.add(CategoryDTOAdapter.getCategory(newCategoryDTO));
            }

            product.setCategories(categories);

            product.setCreatedBy(newProductDTO.getCreatedBy());
            product.setCreatedDateTime(newProductDTO.getCreatedDateTime());
            product.setLastModified(newProductDTO.getLastModified());
        }

        return product;
    }

    public static NewProductDTO getProductDTO(Product product) {
        NewProductDTO newProductDTO = new NewProductDTO();

        if(product != null) {
            newProductDTO.setName(product.getName());
            newProductDTO.setPrice(product.getPrice());
            newProductDTO.setDescription(product.getDescription());
            newProductDTO.setImages(product.getImages());

            List<NewAttributeDTO> attributeDTOS = new ArrayList<>();

            for(Attribute attribute: product.getAttributes()) {
                attributeDTOS.add(AttributeDTOAdapter.getNewAttributeDTO(attribute));
            }

            newProductDTO.setAttributes(attributeDTOS);

            List<NewCategoryDTO> categoryDTOS = new ArrayList<>();

            for(Category category: product.getCategories()) {
                categoryDTOS.add(CategoryDTOAdapter.getCategoryDTO(category));
            }

            newProductDTO.setCategories(categoryDTOS);

            newProductDTO.setCreatedBy(product.getCreatedBy());
            newProductDTO.setCreatedDateTime(product.getCreatedDateTime());
            newProductDTO.setLastModified(product.getLastModified());
        }

        return newProductDTO;
    }
}
