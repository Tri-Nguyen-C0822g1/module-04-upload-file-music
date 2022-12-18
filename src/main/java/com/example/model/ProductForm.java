package com.example.model;

import org.springframework.web.multipart.MultipartFile;

public class ProductForm {
    private int id;
    private String name;
    private String singer;
    private String type;
    private MultipartFile song;

    public ProductForm(){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProductForm(String name, String singer, String type, MultipartFile song) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.type = type;
        this.song = song;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public MultipartFile getSong() {
        return song;
    }

    public void setSong(MultipartFile song) {
        this.song = song;
    }
}
