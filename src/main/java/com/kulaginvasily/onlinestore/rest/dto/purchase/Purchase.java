package com.kulaginvasily.onlinestore.rest.dto.purchase;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
public class Purchase {
    @NotNull
    @Schema(description = "id")
    @JsonProperty("id")
    private Long id;



    @NotNull
    @Schema(description = "number", required = true)
    @JsonProperty("number")
    private Integer number;

}