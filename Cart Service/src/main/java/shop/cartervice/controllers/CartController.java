package shop.cartervice.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/cart")
public class CartController {

    @GetMapping("")
    public ResponseEntity<?> getCart() {
        return new ResponseEntity<>("Cart", HttpStatus.OK);
    }
}
