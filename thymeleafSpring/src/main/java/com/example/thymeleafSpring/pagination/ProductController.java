package com.example.thymeleafSpring.pagination;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ProductController {
    private ProductServise servise;

    @GetMapping("/products")
    public String viewProduct(@RequestParam("page") Optional<Integer> page,
                              Model model){

        model.addAttribute("products",servise.getNowPage(page.orElse(1)));
        model.addAttribute("product",new Product());
        model.addAttribute("countPage",servise.getCountPage()+1);
        model.addAttribute("nowPage",page.orElse(1));

//        //создаем номера страниц
//        if (servise.getCountPage() > 0) {
//            List<Integer> pageNumbers = IntStream.rangeClosed(1, servise.getCountPage()+1)
//                    .boxed()
//                    .collect(Collectors.toList());
//            model.addAttribute("pageNumbers", pageNumbers);
//        }

        return "products";
    }

    @PostMapping("/products/add")
    public String addProduct(@ModelAttribute(value = "product")Product product) {
        servise.add(product);
        return "redirect:/products";
    }

    public ProductController(ProductServise servise) {
        this.servise = servise;
    }
}
