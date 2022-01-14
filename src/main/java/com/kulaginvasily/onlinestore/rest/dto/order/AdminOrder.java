package com.kulaginvasily.onlinestore.rest.dto.order;

import com.kulaginvasily.onlinestore.orders.Delivery;
import com.kulaginvasily.onlinestore.orders.OrderStatus;
import com.kulaginvasily.onlinestore.orders.Payment;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@Data
@Schema(description = "данные для заказа админа")
public class AdminOrder {
    private Long id;
    private String usersName;
    private String usersNumber;
    private String address;
    private LocalDateTime time;
    private Delivery delivery;
    private Payment payment;
    private OrderStatus orderStatus;
    private Map<Long, Integer> cakes;
    private BigDecimal price;
    private String allCakesNames;
}