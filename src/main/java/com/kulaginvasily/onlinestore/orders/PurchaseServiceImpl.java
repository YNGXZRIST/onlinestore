package com.kulaginvasily.onlinestore.orders;

import com.kulaginvasily.onlinestore.goods.CakeEntity;
import com.kulaginvasily.onlinestore.orders.OrderEntity;
import com.kulaginvasily.onlinestore.orders.OrderService;
import com.kulaginvasily.onlinestore.orders.OrderServiceImpl;
import com.kulaginvasily.onlinestore.orders.PurchaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImpl implements PurchaseService{
    private final PurchaseRepository purchaseRepository;

    @Autowired
    public PurchaseServiceImpl(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }


    @Override
    public void addPurchase(OrderEntity orderEntity, CakeEntity cakeEntity, Integer number) {
        PurchaseEntity purchase = new PurchaseEntity();
        purchase.setNumber(number);
        purchase.setOrder(orderEntity);
        purchase.setCake(cakeEntity);
        purchaseRepository.saveAndFlush(purchase);
    }
}