package com.cofeterii.organizer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {
    private List<Product> cartItems = new ArrayList<>();

    @GetMapping("/cart")
    public String getCart(Model model) {
        model.addAttribute("cartItems", cartItems);
        return "cart";
    }

    @PostMapping("/cart/add")
    public String addToCart(@ModelAttribute("product") Product product) {
        cartItems.add(product);
        return "redirect:/cart";
    }
}
