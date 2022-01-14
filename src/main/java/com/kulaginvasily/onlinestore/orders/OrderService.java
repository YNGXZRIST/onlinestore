package com.kulaginvasily.onlinestore.orders;

import com.kulaginvasily.onlinestore.rest.dto.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderService {
    OrderEntity addOrder(Order order);
    void deleteOrder(Long id);




}
