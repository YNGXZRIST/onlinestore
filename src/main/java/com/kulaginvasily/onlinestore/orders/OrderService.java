package com.kulaginvasily.onlinestore.orders;

import com.kulaginvasily.onlinestore.rest.dto.order.AdminOrder;
import com.kulaginvasily.onlinestore.rest.dto.order.Order;
import com.kulaginvasily.onlinestore.rest.dto.order.OrderFullInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderService {
    void addOrder(Order order);
    OrderFullInfo getOrder(Long id);
    void deleteOrder(Long id);
    List<OrderFullInfo> getOrders();


}
