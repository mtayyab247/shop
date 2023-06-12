package shop.productservice.controller;

import jakarta.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.productservice.model.Attribute;
import shop.productservice.service.impl.AttributeService;

import java.util.List;

@RestController
@RequestMapping("api/v1/attribute")
public class AttributeController {

    private AttributeService attributeService;

    @Autowired
    public AttributeController(AttributeService attributeService) {
        this.attributeService = attributeService;
    }

    @GetMapping("")
    public ResponseEntity<?> listAttributes() {
        
        return new ResponseEntity<List<Attribute>>(attributeService.listAttributes(), HttpStatus.OK);
    }

//    @GetMapping("")
//    public ResponseEntity

    @GetMapping("/{name}")
    public ResponseEntity<?> getAttribute(@PathVariable("name") String name) {
        System.out.println(name);
        return new ResponseEntity<Attribute>(attributeService.getAttributeByName(name), HttpStatus.OK);
    }
}
