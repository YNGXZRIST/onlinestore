package com.kulaginvasily.onlinestore.goods;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;

public interface CakeRepository extends JpaRepository<CakeEntity, Long> {
    boolean existsByName(String name);
}
