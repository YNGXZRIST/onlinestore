package com.kulaginvasily.onlinestore.orders;

import com.kulaginvasily.onlinestore.goods.CakeEntity;

public interface PurchaseService {
    void addPurchase(OrderEntity orderEntity, CakeEntity cakeEntity, Integer count);

}
