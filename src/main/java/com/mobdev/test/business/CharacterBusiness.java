package com.mobdev.test.business;


import com.mobdev.test.controller.model.CharacterDto;

public interface CharacterBusiness {
    CharacterDto getById(Integer id);
}
