package com.homeproject.homeproject.service;

import com.homeproject.homeproject.exceptions.MyPersonalExceptionBad;
import com.homeproject.homeproject.exceptions.MyPersonalExceptionFound;
import com.homeproject.homeproject.model.OrderDto;
import com.homeproject.homeproject.repository.Order;
import com.homeproject.homeproject.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Validated
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrderDto() {
        return orderRepository.findAll();
    }

    @Override
    public void createOrder(OrderDto orderDto) {
        Optional<Order> orderOp = orderRepository.findById(orderDto.getId());
        if (orderOp.isPresent()) {
            throw new MyPersonalExceptionBad("Order Already Exists!");
        }
    }

    @Override
    public Order readOrderById(UUID id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new MyPersonalExceptionFound("Order Not Found!"));
    }

    @Override
    public Order updateOrder(Order order) {
        this.readOrderById(order.getId());
        return orderRepository.save(order);

    }

    @Override
    public void deleteOrder(UUID id) {
        this.readOrderById(id);
        orderRepository.deleteById(id);
    }
}
