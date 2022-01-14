package com.kulaginvasily.onlinestore.rest.dto.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kulaginvasily.onlinestore.orders.Delivery;
import com.kulaginvasily.onlinestore.orders.OrderService;
import com.kulaginvasily.onlinestore.orders.OrderStatus;
import com.kulaginvasily.onlinestore.orders.Payment;
import com.kulaginvasily.onlinestore.rest.dto.purchase.Purchase;
import com.kulaginvasily.onlinestore.rest.dto.user.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data

@Schema(description = "Информация о доставке")
@Validated
public class Order {
    @NotNull
    @Schema(description = "Информация о пользователе", required = true)
    @JsonProperty("user")
    private User user;
    @NotNull
    @Schema(description = "delivery", required = true)
    @JsonProperty("способ получения заказа")
    private Delivery delivery;

    @NotNull
    @Schema(description = "адресс доставки", required = true)
    @JsonProperty("deliveryAddress")
    private String deliveryAddress;

    @NotNull
    @Schema(description = "Время доставки", required = true)
    @JsonProperty("deliveryTime")
    private LocalDateTime deliveryTime;

    @NotNull
    @Schema(description = "Время доставки", required = true)
    @JsonProperty("deliveryDate")
    private LocalDateTime deliveryDate;

    @NotNull
    @Schema(description = "способ оплаты", required = true)
    @JsonProperty("payment")
    private Payment payment;

    @NotNull
    @Schema(description = "статус доставки", required = true)
    @JsonProperty("orderStatus")
    private OrderStatus orderStatus;

    @NotNull
    @Schema(description = "purchases", required = true)
    @JsonProperty("purchases")
    private List<Purchase> purchases;
}
