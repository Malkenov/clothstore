package com.example.clothstore.clothstore.controller;


import com.example.clothstore.clothstore.entity.Product;
import com.example.clothstore.clothstore.repository.ProductRepository;
import com.example.clothstore.clothstore.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }


    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{get-product-id}")
    public Product getById(Long product_id){
        return productService.getById(product_id);
    }

    @PostMapping("/{add-product-id")
    public Product postProduct(@RequestBody Product product,Long category_id){
        return productService.addProduct(product,category_id);
    }

    @PutMapping("/{update-product-id}")
    public Product putProduct(
            @PathVariable Long product_id,
            @RequestBody Product product,
            @PathVariable Long category_id){
        return productService.updateProduct(product_id,product,category_id);
    }

    @DeleteMapping("/{delete-id}")
    public void removeProduct(long id){
        productService.deleteProduct(id);
    }
}
