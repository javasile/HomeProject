package com.homeproject.homeproject.controller;

import com.homeproject.homeproject.model.ClientDto;
import com.homeproject.homeproject.model.OrderDto;
import com.homeproject.homeproject.repository.Client;
import com.homeproject.homeproject.repository.Order;
import com.homeproject.homeproject.service.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderServiceImpl orderService;

    @GetMapping("/allOrder")
    @ResponseStatus(OK)
    public List<Order> findAllOrder() {
        return orderService.getAllOrderDto();
    }

    @PostMapping("/newOrder")
    public void createOrder(@RequestBody OrderDto orderDto) {
        orderService.createOrder(orderDto);
    }

    @GetMapping(value = "/order/{id}")
    public Order readOrderById(@PathVariable("id") UUID id) {
        return orderService.readOrderById(id);
    }

    @PutMapping("/editOrder")
    public void updateOrder(@RequestBody Order order) {
        orderService.updateOrder(order);
    }

    @PatchMapping("/updateOrder")
    public void updateOrder2(@RequestBody Order order) {
        orderService.updateOrder(order);
    }

    @DeleteMapping("/deleteOrder/{id}")
    public void deleteOrder(@PathVariable UUID id) {
        orderService.deleteOrder(id);
    }
}
