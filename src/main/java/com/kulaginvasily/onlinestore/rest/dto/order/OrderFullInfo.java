package com.kulaginvasily.onlinestore.rest.dto.order;

import com.kulaginvasily.onlinestore.orders.Delivery;
import com.kulaginvasily.onlinestore.orders.OrderService;
import com.kulaginvasily.onlinestore.orders.OrderStatus;
import com.kulaginvasily.onlinestore.orders.Payment;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Data
public class OrderFullInfo {
    private Long id;
    private String usersName;
    private String usersNumber;
    private String deliveryAddress;
    private LocalDateTime deliveryDate;
    private LocalDateTime deliveryTime;
    private Delivery delivery;
    private Payment payment;
    private OrderStatus orderStatus;
    private Map<Long, Integer> cakes;
    private List<InOrder> cakesList;
    private BigDecimal paymentSum;
    private String allCakesNames;


}
