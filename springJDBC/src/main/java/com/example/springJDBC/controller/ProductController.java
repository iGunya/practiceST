package com.example.springJDBC.controller;

import com.example.springJDBC.entities.Product;
import com.example.springJDBC.service.PersonServiсe;
import com.example.springJDBC.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    PersonServiсe personServiсe;

    @GetMapping("/products")
    public String viewProduct(@RequestParam("page") Optional<Integer> page,
                              @RequestParam("id") Long id,
                              Model model){

        model.addAttribute("products",productService.getNowPage(page.orElse(1),id));
        model.addAttribute("product",new Product());
        model.addAttribute("id",id);
        model.addAttribute("countPage",productService.getCountPage()+1);
        model.addAttribute("nowPage",page.orElse(1));

        return "products-user";
    }

    @PostMapping("/products/add")
    public String addProduct(@ModelAttribute(value = "product") Product product,
                             @RequestParam(value = "id") Long id) {
        productService.add(product,personServiсe.findById(id));
        return "redirect:/products?id="+id;
    }
    public ProductController(ProductService productService, PersonServiсe personServiсe) {
        this.productService = productService;
        this.personServiсe = personServiсe;
    }
}
