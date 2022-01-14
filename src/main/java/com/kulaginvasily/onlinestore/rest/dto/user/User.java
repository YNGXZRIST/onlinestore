package com.kulaginvasily.onlinestore.rest.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
@Schema(description = "User's data")
@Validated
public class User {


    @NotNull
    @Schema(description = "Телефон пользователя", required = true)
    @JsonProperty("number")
    private String number;

    @NotNull
    @Schema(description = "Имя пользователя", required = true)
    @JsonProperty("name")
    private String name;

}
