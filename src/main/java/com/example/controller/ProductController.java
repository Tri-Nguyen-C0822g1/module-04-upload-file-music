package com.example.controller;


import com.example.model.Product;
import com.example.model.ProductForm;
import com.example.service.IProductService;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Value("${file-upload}")
    private String fileUpload;

    private final IProductService productService = new ProductService();

    @GetMapping("")
    public String showList(Model model){
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "/index";
    }
    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("productForm", new ProductForm());
        return "/create";
    }
    @PostMapping("/save")
    public ModelAndView save (@ModelAttribute ProductForm productForm){
        MultipartFile multipartFile = productForm.getSong();
        String fileName = multipartFile.getOriginalFilename();
        if (fileName.toLowerCase().endsWith(".mp3") || fileName.toLowerCase().endsWith(".wav")|| fileName.toLowerCase().endsWith(".m4p")){
        try{
            FileCopyUtils.copy(productForm.getSong().getBytes(), new File(fileUpload + fileName));
        } catch (IOException e){
            e.printStackTrace();
        }
        Product product = new Product(productForm.getId(), productForm.getName(), productForm.getSinger(),productForm.getType(),fileName);
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("productForm", productForm);
        modelAndView.addObject("message", "Created new song successfully!!");
        return modelAndView;
    } else {
            ModelAndView modelAndView = new ModelAndView("/create");
            modelAndView.addObject("message", "The application only accepts music files with the extension .mp3, .wav, .ogg, .m4p!!");
        return modelAndView;
        }
    }
}
