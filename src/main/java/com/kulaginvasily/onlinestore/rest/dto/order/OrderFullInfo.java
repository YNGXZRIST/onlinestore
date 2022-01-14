package com.kulaginvasily.onlinestore.rest.dto.order;

import com.kulaginvasily.onlinestore.orders.Delivery;
import com.kulaginvasily.onlinestore.orders.OrderService;
import com.kulaginvasily.onlinestore.orders.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

public class OrderFullInfo {
    private Long id;
    private String usersName;
    private String usersNumber;
    private String deliveryAddress;
    private LocalDateTime deliveryDate;
    private Delivery delivery;
    private OrderService.Payment payment;
    private OrderStatus orderStatus;
    private Map<Long, Integer> cakes;
    private BigDecimal price;
    private String allCakesNames;
}
