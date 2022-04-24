package com.mobdev.test.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "OriginDto", description = "Object with information of the character's origin")
public class OriginDto {
    @ApiModelProperty("Name of the origin planet")
    @JsonProperty("name")
    private String name;
    @ApiModelProperty("Url of origin planet")
    @JsonProperty("url")
    private String url;
    @ApiModelProperty("Name of the dimension to which the planet belongs")
    @JsonProperty("dimension")
    private String dimension;
    @ApiModelProperty("URLs of characters residing on the planet")
    @JsonProperty("residents")
    private List<String> residents;
}
