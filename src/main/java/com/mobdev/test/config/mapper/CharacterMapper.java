package com.mobdev.test.config.mapper;

import com.mobdev.test.controller.model.CharacterDto;
import com.mobdev.test.client.model.CharacterServerDto;
import org.mapstruct.Mapper;

import static com.mobdev.test.util.Util.getLocationIdByUrl;

@Mapper(componentModel = "spring")
public interface CharacterMapper {
    CharacterDto mapToCharacterDto (CharacterServerDto characterServerDto);

    default CharacterDto toCharacterDto(CharacterServerDto characterServerDto) {
        CharacterDto characterDto = mapToCharacterDto(characterServerDto);
        characterDto.setEpisodeCount(characterServerDto.getEpisode().size());
        characterDto.setOriginId(getLocationIdByUrl(characterServerDto.getOrigin().getUrl()));
        return characterDto;
    }
}
