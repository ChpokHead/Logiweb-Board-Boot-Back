package com.chpok.logiwebboardboot.controller;

import com.chpok.logiwebboardboot.model.OrderEntity;
import com.chpok.logiwebboardboot.repository.OrderRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {
    private static final String CURRENT_YEAR = String.valueOf(LocalDate.now().getYear());
    private static final String CURRENT_MONTH = String.valueOf(LocalDate.now().getMonth().getValue());
    private static final String DATE_DELIMITER = "-";
    private static final int YEAR_INDEX = 0;
    private static final int MONTH_INDEX = 1;

    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/orders")
    public List<OrderEntity> getOrders() {
        List<OrderEntity> orders = orderRepository.findTop10ByOrderByIdDesc();

        return getCurrentMonthOrders(orders);
    }

    private List<OrderEntity> getCurrentMonthOrders(List<OrderEntity> orders) {
        final List<OrderEntity> currentMonthOrders = new ArrayList<>();

        for (OrderEntity order : orders) {
            if (order.getCreationDate().split(DATE_DELIMITER)[YEAR_INDEX].equals(CURRENT_YEAR)
                    && Integer.parseInt(order.getCreationDate().split(DATE_DELIMITER)[MONTH_INDEX]) == (Integer.parseInt(CURRENT_MONTH))) {
                currentMonthOrders.add(order);
            }
        }

        return currentMonthOrders;
    }
}
