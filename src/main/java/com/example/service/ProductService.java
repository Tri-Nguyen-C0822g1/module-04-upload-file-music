package com.example.service;

import com.example.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService{

    List<Product> products = new ArrayList<>();

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public void update(int id, Product product) {
        for (Product p : products){
            if(p.getId() == id){
                products.add(p);
                break;
            }
        }
    }

    @Override
    public void remove(int id) {
        for(Product p : products){
            if (p.getId() == id){
                products.remove(p);
                break;
            }
        }
    }

    @Override
    public List<Product> findByNameOrSinger(String search) {
        List<Product> list = new ArrayList<>();
        for(Product p : products){
            if(p.getName().equals(search) || p.getSinger().equals(search)){
                list.add(p);
                break;
            }
        }
        return list;
    }
}
