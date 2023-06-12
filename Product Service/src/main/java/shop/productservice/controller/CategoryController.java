package shop.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shop.productservice.model.Category;
import shop.productservice.service.impl.CategoryService;

import java.util.List;

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
}
