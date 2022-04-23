package com.mobdev.test.business.impl;

import com.mobdev.test.business.CharacterBusiness;
import com.mobdev.test.config.exception.CustomException;
import com.mobdev.test.controller.model.CharacterDto;
import com.mobdev.test.config.mapper.CharacterMapper;
import com.mobdev.test.service.CharacterService;
import com.mobdev.test.service.LocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CharacterBusinessImpl implements CharacterBusiness {
    CharacterService service;
    LocationService locationService;
    CharacterMapper mapper;

    @Autowired
    public CharacterBusinessImpl(CharacterService service,
                                 LocationService locationService,
                                 CharacterMapper mapper
                                 ) {
        this.service = service;
        this.locationService = locationService;
        this.mapper = mapper;
    }

    @Override
    public CharacterDto getById(Integer id) throws CustomException {
        CharacterDto characterDto = service.getById(id);
        characterDto.setOrigin(locationService.getById(characterDto.getOriginId()));
        return characterDto;
    }
}
