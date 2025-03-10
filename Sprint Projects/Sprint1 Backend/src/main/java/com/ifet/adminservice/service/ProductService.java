package com.ifet.adminservice.service;

import com.ifet.adminservice.model.Product;
import com.ifet.adminservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        return productRepository.findById(id).map(existingProduct -> {
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setPrice(updatedProduct.getPrice());
            return productRepository.save(existingProduct);
        }).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
