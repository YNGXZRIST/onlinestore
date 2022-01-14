package com.kulaginvasily.onlinestore.orders;

import com.kulaginvasily.onlinestore.goods.CakeEntity;
import com.kulaginvasily.onlinestore.goods.CakeRepository;
import com.kulaginvasily.onlinestore.rest.dto.order.Order;
import com.kulaginvasily.onlinestore.users.UserRepository;
import com.kulaginvasily.onlinestore.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService{
    private final OrderRepository orderRepository;
    private final PurchaseRepository purchaseRepository;
    private final UserRepository userRepository;
    private final CakeRepository cakeRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, PurchaseRepository purchaseRepository, UserService userService, UserRepository userRepository, CakeRepository cakeRepository) {
        this.orderRepository = orderRepository;
        this.purchaseRepository = purchaseRepository;
        this.userRepository = userRepository;
        this.cakeRepository = cakeRepository;
    }

    @Override
    public OrderEntity addOrder(Order order) {
        OrderEntity orderEntity=new OrderEntity();
        orderEntity.setDelivery(order.getDelivery());
        orderEntity.setPayment(order.getPayment());
        orderEntity.setOrderStatus(order.getOrderStatus());
        orderEntity.setDeliveryDate(order.getDeliveryDate());
        orderEntity.setDeliveryTime(order.getDeliveryTime());
        orderEntity.setDeliveryAddress(order.getDeliveryAddress());

        orderEntity.setPurchases(order.getPurchases().stream()
                .map(purchase -> {
                    PurchaseEntity purchaseEntity = new PurchaseEntity();
                    purchaseEntity.setNumber(purchase.getNumber());
                    purchaseEntity.setOrder(orderEntity);
                    purchaseEntity.setCake(cakeRepository.findById(purchase.getId()).orElseThrow(RuntimeException::new));
                    return purchaseEntity;
                }).collect(Collectors.toList()));
        orderEntity.setUser(userRepository.findUserByNumber(order.getUser().getNumber()));
        orderRepository.saveAndFlush(orderEntity);

    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public static interface PurchaseService {
    void addPurchase(OrderEntity orderEntity, CakeEntity cakeEntity, Integer count);
    }
}