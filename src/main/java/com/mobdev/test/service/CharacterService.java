package com.mobdev.test.service;

import com.mobdev.test.config.exception.CustomException;
import com.mobdev.test.controller.model.CharacterDto;

public interface CharacterService {
    CharacterDto getById(Integer id) throws CustomException;
}
