package com.kulaginvasily.onlinestore.orders;

import com.kulaginvasily.onlinestore.exception.OrderNotFoundException;
import com.kulaginvasily.onlinestore.goods.CakeEntity;
import com.kulaginvasily.onlinestore.goods.CakeRepository;
import com.kulaginvasily.onlinestore.rest.dto.order.InOrder;
import com.kulaginvasily.onlinestore.rest.dto.order.Order;
import com.kulaginvasily.onlinestore.rest.dto.order.OrderFullInfo;
import com.kulaginvasily.onlinestore.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final CakeRepository cakeRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, PurchaseRepository purchaseRepository,
     UserRepository userRepository, CakeRepository cakeRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.cakeRepository = cakeRepository;

    }

    @Override
    public void addOrder(Order order) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setDelivery(order.getDelivery());
        orderEntity.setPayment(order.getPayment());
        orderEntity.setStatus(order.getOrderStatus());
        orderEntity.setDeliveryTime(order.getDeliveryTime());
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

    @Override
    public OrderFullInfo getOrder(Long id) {
        return orderRepository.findById(id)
                .map(orderEntity -> {
                    OrderFullInfo orderFullInfo = new OrderFullInfo();
                    orderFullInfo.setId(orderEntity.getId());
                    orderFullInfo.setUsersNumber(orderEntity.getUser().getNumber());
                    orderFullInfo.setUsersName(orderEntity.getUser().getName());
                    orderFullInfo.setDelivery(orderEntity.getDelivery());
                    orderFullInfo.setDeliveryAddress(orderEntity.getDeliveryAddress());
                    orderFullInfo.setDeliveryDate(orderEntity.getDeliveryDate());
                    orderFullInfo.setDeliveryTime(orderEntity.getDeliveryTime());
                    orderFullInfo.setOrderStatus(orderEntity.getStatus());
                    orderFullInfo.setPayment(orderEntity.getPayment());

                    AtomicReference<BigDecimal> paymentSum = new AtomicReference<>(BigDecimal.ZERO);

                    List<InOrder> pairList = orderEntity.getPurchases().stream().map(purchase -> {
                        InOrder cakeInOrderInfo = cakeRepository.findById(purchase.getCake().getId()).map(
                                        cakeEntity -> {
                                            InOrder cake = new InOrder();
                                            cake.setName(cakeEntity.getName());
                                            cake.setPrice(cakeEntity.getPrice());
                                            return cake;
                                        }
                                ).orElse(new InOrder());
                                cakeInOrderInfo.setNumber(purchase.getNumber());
                                paymentSum.updateAndGet(v -> v.add(cakeInOrderInfo.getPrice().multiply(BigDecimal.valueOf(purchase.getNumber()))));
                                return cakeInOrderInfo;
                            }
                    ).collect(Collectors.toList());


                    orderFullInfo.setCakesList(pairList);
                    orderFullInfo.setPaymentSum(paymentSum.get());
                    orderFullInfo.setPayment(orderEntity.getPayment());
                    return orderFullInfo;
                })
                .orElseThrow(() -> new OrderNotFoundException("No such order"));

    }



}