package com.kulaginvasily.onlinestore.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.math.BigDecimal;

@Data
@Schema(description = "Полные данные о торте")
@Validated
public class CakeFullInfo {
    @Null
    @Schema(description = "идентификатор торта", required = false)
    @JsonProperty("id")
    private Long id;

    @NotNull
    @Schema(description = "Название торта", required = true)
    @JsonProperty("name")
    private String name;

    @NotNull
    @Schema(description = "число калорий", required = true)
    @JsonProperty("calories")
    private BigDecimal calories;

    @NotNull
    @Schema(description = "относительный url картинки торта", required = true)
    @JsonProperty("image")
    private String image;

    @NotNull
    @Schema(description = "цена торта", required = true)
    @JsonProperty("price")
    private BigDecimal price;

    @NotNull
    @Schema(description = "вес торта", required = true)
    @JsonProperty("weight")
    private BigDecimal weight;

    @NotNull
    @Schema(description = "состав торта",required = true)
    @JsonProperty("composition")
    private String composition;

}
