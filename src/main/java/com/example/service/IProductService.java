package com.example.service;

import com.example.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void save (Product product);
    void update (int id, Product product);
    void remove(int id);
    List<Product> findByNameOrSinger(String search);
}
