package com.example.SpringMVC.postExample;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class PostExampleController {
    //в идеале передовать в контроллер через сервис
    ProductRepository productRepository;

    @GetMapping("/post-example")
    public String simplePost(){
        return "postExample" ;
    }

    @PostMapping("/post-example")
    public String simplePost(@RequestParam(value="name") String nameProduct,
                          @RequestParam(value="price") String priceProduct, Model model){
        productRepository.add(new Product(nameProduct,Integer.parseInt(priceProduct)));
        model.addAttribute("products", productRepository.getProducts());
        model.addAttribute("product", new Product());
        return "responsePost";
    }

    public PostExampleController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
