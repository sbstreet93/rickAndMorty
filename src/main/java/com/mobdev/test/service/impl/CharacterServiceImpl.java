package com.mobdev.test.service.impl;

import com.mobdev.test.config.exception.CustomException;
import com.mobdev.test.controller.model.CharacterDto;
import com.mobdev.test.client.CharacterControllerClient;
import com.mobdev.test.client.model.CharacterServerDto;
import com.mobdev.test.config.mapper.CharacterMapper;
import com.mobdev.test.service.CharacterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CharacterServiceImpl implements CharacterService {
    CharacterControllerClient client;
    CharacterMapper mapper;

    @Autowired
    public CharacterServiceImpl(CharacterControllerClient client,
                                 CharacterMapper mapper
    ) {
        this.client = client;
        this.mapper = mapper;
    }

    @Override
    public CharacterDto getById(Integer id) throws CustomException {
        CharacterServerDto characterServerDto = client.getById(id);
        CharacterDto characterDto = mapper.toCharacterDto(characterServerDto);
        return characterDto;
    }
}
