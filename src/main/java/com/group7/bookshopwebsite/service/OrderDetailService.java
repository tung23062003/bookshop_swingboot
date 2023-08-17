package com.group7.bookshopwebsite.service;

import com.group7.bookshopwebsite.entity.Order;
import com.group7.bookshopwebsite.entity.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    List<OrderDetail> getAllOrderDetailByOrder(Order order);
}
