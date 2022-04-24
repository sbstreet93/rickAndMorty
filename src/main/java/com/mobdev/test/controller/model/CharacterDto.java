package com.mobdev.test.controller.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "CharacterDto", description = "Object with the character's information")
public class CharacterDto {
    @ApiModelProperty(value = "Character id")
    @JsonProperty("id")
    private Integer id;
    @ApiModelProperty(value = "Character name")
    @JsonProperty("name")
    private String name;
    @ApiModelProperty(value = "Character status(Alive, Dead, Unknown, etc.)")
    @JsonProperty("status")
    private String status;
    @ApiModelProperty(value = "Character specie(Human, Zombie, Mythological Creature, etc.)")
    @JsonProperty("species")
    private String species;
    @ApiModelProperty(value = "Character sub specie type(God, Devil, Monster, etc)")
    @JsonProperty("type")
    private String type;
    @ApiModelProperty(value = "Count of episodes where the character appears")
    @JsonProperty("episode_count")
    private Integer episodeCount;
    @ApiModelProperty(value = "Object with data about the character origin")
    @JsonProperty("origin")
    private OriginDto origin;
    @JsonIgnore
    private Integer originId;
}
