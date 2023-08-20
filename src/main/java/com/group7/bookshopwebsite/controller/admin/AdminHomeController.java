package com.group7.bookshopwebsite.controller.admin;

import com.group7.bookshopwebsite.controller.common.BaseController;
import com.group7.bookshopwebsite.entity.Order;
import com.group7.bookshopwebsite.service.BookService;
import com.group7.bookshopwebsite.service.OrderService;
import com.group7.bookshopwebsite.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminHomeController extends BaseController {
    private OrderService orderService;
    private UserService userService;
    private BookService bookService;

    @GetMapping
    public String getAdminHomePage(Model model){
        List<Order> orders = orderService.getTop10orders();
        model.addAttribute("orders", orders);
        BigDecimal totalRevenue = orderService.getTotalRevenue();

        Long numberOfUsers = userService.countUser();
        Long numberOfBooks = bookService.countBook();
        Long numberOfOrders = orderService.countOrder();

        model.addAttribute("numberOfUsers", numberOfUsers);
        model.addAttribute("numberOfBooks", numberOfBooks);
        model.addAttribute("numberOfOrders", numberOfOrders);
        model.addAttribute("totalRevenue", totalRevenue);
        return "admin/index";
    }
}
