package com.example.crud.controller;

import com.example.crud.model.Product;
import com.example.crud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    // Obtener todos los productos
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Crear un producto nuevo
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    // Eliminar un producto
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        // 1. Buscamos el producto en la BD
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + id));

        // 2. Actualizamos sus datos con los nuevos
        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        product.setDescription(productDetails.getDescription());
        product.setImage(productDetails.getImage());
        product.setCategory(productDetails.getCategory());
        product.setStock(productDetails.getStock());

        // 3. Guardamos los cambios
        return productRepository.save(product);
    }
}