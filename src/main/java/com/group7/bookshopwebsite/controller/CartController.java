package com.group7.bookshopwebsite.controller;

import com.group7.bookshopwebsite.controller.common.BaseController;
import com.group7.bookshopwebsite.dto.AddToCartRequest;
import com.group7.bookshopwebsite.dto.CartDTO;
import com.group7.bookshopwebsite.dto.CartItemDTO;
import com.group7.bookshopwebsite.entity.Book;
import com.group7.bookshopwebsite.service.BookService;
import com.group7.bookshopwebsite.service.CartService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
@AllArgsConstructor
public class CartController extends BaseController {

    private CartService cartService;
    private BookService bookService;
    private final HttpSession session;
    @GetMapping
    public String getCartPage(Model model){
        CartDTO cart = cartService.getCart(session);
        model.addAttribute("cart", cart);
        double totalCart = 0;
        for (CartItemDTO item : cart.getCartItems()
             ) {
            totalCart += item.getPrice() * item.getQuantity();
        }
        model.addAttribute("totalCart", totalCart);
        return "user/cart";
    }
    @PostMapping("/add-to-cart")
    public ResponseEntity<String> addToCart(@RequestBody AddToCartRequest request) {
        // Assuming AddToCartRequest has fields productId and quantity
        long productId = request.getProductId();
        int quantity = request.getQuantity();

       CartItemDTO addedItem = new CartItemDTO();
       addedItem.setQuantity(quantity);
       addedItem.setBookId(productId);
        Book existingBook = bookService.getBookById(productId);
        addedItem.setTitle(existingBook.getTitle());
        addedItem.setPrice(existingBook.getSalePrice());
        addedItem.setCoverImage(existingBook.getCoverImage());
        cartService.addToCart(session,addedItem);

        System.out.println(cartService.getCart(session).getCartItems().size());
        return ResponseEntity.ok("Item added to cart successfully.");
    }
    @PostMapping("/update-cart-item")
    @ResponseBody
    public ResponseEntity<String> updateCartItem(@RequestParam Long productId, @RequestParam int quantity) {
        cartService.updateCartItemQuantity(session, productId, quantity);
        return ResponseEntity.ok("Cart item updated.");
    }

    @GetMapping("/remove-cart-item/{id}")
    public String removeCartItem(@PathVariable Long id) {
        cartService.removeCartItem(session, id);
        return "redirect:/cart";
    }

    @PostMapping("/clear-cart")
    @ResponseBody
    public ResponseEntity<String> clearCart() {
        cartService.clearCart(session);
        return ResponseEntity.ok("Cart cleared.");
    }
    @GetMapping("/cart-item-count")
    @ResponseBody
    public int getCartItemCount() {
        return cartService.getCart(session).getCartItems().size();
    }

    @GetMapping("/checkout")
    public String getCheckOut(Model model){
        CartDTO cart = cartService.getCart(session);
        model.addAttribute("cart", cart);
        double totalCart = 0;
        for (CartItemDTO item : cart.getCartItems()
        ) {
            totalCart += item.getPrice() * item.getQuantity();
        }
        model.addAttribute("totalCart", totalCart);
        return "user/checkout";
    }
}
