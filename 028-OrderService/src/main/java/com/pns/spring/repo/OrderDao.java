package com.pns.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pns.spring.model.Order;

public interface OrderDao extends JpaRepository<Order, Integer>{

}
