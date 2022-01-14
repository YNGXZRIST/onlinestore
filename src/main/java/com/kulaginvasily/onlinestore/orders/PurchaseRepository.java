package com.kulaginvasily.onlinestore.orders;

import org.springframework.data.jpa.repository.JpaRepository;

interface PurchaseRepository extends JpaRepository<PurchaseEntity,Long> {
}
