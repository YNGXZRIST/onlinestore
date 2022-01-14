package com.kulaginvasily.onlinestore.orders;

import com.kulaginvasily.onlinestore.rest.dto.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderService {
    void addOrder(Order order);
    void deleteOrder(Long id);




}
