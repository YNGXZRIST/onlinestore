package com.kulaginvasily.onlinestore.rest.dto.order;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class InOrder {
    private String name;
    private BigDecimal price;
    private Integer number;
}
