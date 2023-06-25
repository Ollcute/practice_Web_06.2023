package com.cofeterii.organizer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class CartController {
    private Cart cart;

    public CartController() {
        this.cart = new Cart();
    }

    @GetMapping("/product")
    public String getProductPage(Model model) {
        // Подготовка модели для отображения страницы с информацией о продукте
        Product product = new Product("Капучино с лесным орехом", "Ароматный кофе с нежными нотками шоколада и орехов");
        model.addAttribute("product", product);
        return "product";
    }

    @PostMapping("/product/addToCart")
    public String addToCart(@RequestParam("productName") String productName) {
        // Получение информации о продукте из формы HTML и добавление его в корзину
        Product product = new Product(productName, "");
        cart.addProduct(product);
        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String getCartPage(Model model) {
        // Подготовка модели для отображения страницы с содержимым корзины
        model.addAttribute("cart", cart);
        return "cart";
    }
}
