package shop.productservice.controller;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import shop.productservice.model.Category;
import shop.productservice.service.dto.NewCategoryDTO;
import shop.productservice.service.impl.CategoryService;

@RestController
@RequestMapping("api/v1/category")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("")
    public ResponseEntity<Page<Category>> listCategories(@RequestParam(defaultValue = "0") int pageNumber,
                                            @RequestParam(defaultValue = "5") int pageSize) {
        return new ResponseEntity<Page<Category>>(categoryService.listCategories(pageNumber, pageSize), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable("id") Integer id) {
        try {
            return new ResponseEntity<Category>(categoryService.getCategoryByID(id), HttpStatus.OK);
        } catch (EntityNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Category with id=%d not found!", id), exception);
        }
    }

    @PostMapping("")
    public ResponseEntity<?> createCategory(@RequestBody NewCategoryDTO newCategoryDTO) {
        return new ResponseEntity<NewCategoryDTO>(categoryService.saveProductCategory(newCategoryDTO), HttpStatus.CREATED);
    }
}
