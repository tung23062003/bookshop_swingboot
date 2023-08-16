package com.group7.bookshopwebsite.repository;

import com.group7.bookshopwebsite.entity.Order;
import com.group7.bookshopwebsite.entity.OrderDetail;
import com.group7.bookshopwebsite.entity.composite_key.OrderDetailId;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailId> {
    List<OrderDetail> findByOrder(Order order);
}
