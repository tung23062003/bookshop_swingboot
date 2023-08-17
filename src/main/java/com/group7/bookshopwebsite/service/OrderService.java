package com.group7.bookshopwebsite.service;

import com.group7.bookshopwebsite.dto.CartDTO;
import com.group7.bookshopwebsite.dto.OrderPerson;
import com.group7.bookshopwebsite.entity.Order;
import com.group7.bookshopwebsite.entity.User;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();

    List<Order> getAllOrdersByUser(User user);
    Order getOrderById(Long orderId);

    Order createOrder(CartDTO cart, User user, OrderPerson orderPerson);

    Order updateOrder(Order order);

    void deleteOrder(Long orderId);

    void cancelOrder(Order order);
}
