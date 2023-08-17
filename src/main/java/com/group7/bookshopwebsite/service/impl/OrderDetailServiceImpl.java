package com.group7.bookshopwebsite.service.impl;

import com.group7.bookshopwebsite.entity.Order;
import com.group7.bookshopwebsite.entity.OrderDetail;
import com.group7.bookshopwebsite.repository.OrderDetailRepository;
import com.group7.bookshopwebsite.repository.OrderRepository;
import com.group7.bookshopwebsite.service.OrderDetailService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    private OrderDetailRepository orderDetailRepository;
    @Override
    public List<OrderDetail> getAllOrderDetailByOrder(Order order) {
        return orderDetailRepository.findByOrder(order);
    }
}
