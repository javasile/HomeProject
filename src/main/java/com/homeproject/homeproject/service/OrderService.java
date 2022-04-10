package com.homeproject.homeproject.service;

import com.homeproject.homeproject.model.OrderDto;
import com.homeproject.homeproject.repository.Order;


import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

public interface OrderService {

    List<Order> getAllOrderDto();

    void createOrder(@Valid OrderDto orderDto);

    Order readOrderById(UUID id);

    Order updateOrder(Order order);

    void deleteOrder(UUID id);
}
