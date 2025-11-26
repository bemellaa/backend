package com.example.crud.service;

import com.example.crud.model.Product;
import com.example.crud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // <--- ¡ESTO ES MUY IMPORTANTE! Sin esto, no funciona.
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // 1. Obtener todos los productos
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    // 2. Obtener un producto por ID
    public Optional<Product> getProduct(Long id){
        return productRepository.findById(id);
    }

    // 3. Guardar o Actualizar un producto (Lógica de negocio simple)
    public void saveOrUpdate(Product product){
        productRepository.save(product);
    }

    // 4. Eliminar un producto
    public void delete(Long id){
        productRepository.deleteById(id);
    }
}