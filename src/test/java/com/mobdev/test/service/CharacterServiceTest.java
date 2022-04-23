package com.mobdev.test.service;

import com.mobdev.test.controller.model.CharacterDto;
import com.mobdev.test.client.CharacterControllerClient;
import com.mobdev.test.client.model.CharacterServerDto;
import com.mobdev.test.client.model.ItemServerDto;
import com.mobdev.test.config.mapper.CharacterMapper;
import com.mobdev.test.service.impl.CharacterServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(MockitoJUnitRunner.class)
public class CharacterServiceTest {
    @Autowired
    private MockMvc mockMvc;
    @Spy
    private CharacterMapper characterMapper = Mappers.getMapper(CharacterMapper.class);
    @Mock
    private CharacterControllerClient characterControllerClient;
    @InjectMocks
    private CharacterServiceImpl characterService;

    private static final Integer CHARACTER_ID = 1;

    @Before
    public void init()
    {
        Mockito.
                when(characterControllerClient.getById(Mockito.anyInt()))
                .thenReturn(getCharacterServerDto());
        mockMvc = standaloneSetup(characterService).build();
    }

    @Test
    public void getById() {
        CharacterDto characterDto = characterService.getById(CHARACTER_ID);
        Assert.assertTrue(characterDto.getId() == CHARACTER_ID);
    }

    public CharacterServerDto getCharacterServerDto(){
        return CharacterServerDto.builder()
                .id(CHARACTER_ID)
                .name("Morty Smith")
                .status("Alive")
                .species("Human")
                .type("")
                .gender("Male")
                .origin(ItemServerDto.builder()
                        .name("Earth")
                        .url("https://rickandmortyapi.com/api/location/1")
                        .build())
                .location(ItemServerDto.builder()
                        .name("Earth")
                        .url("https://rickandmortyapi.com/api/location/20")
                        .build())
                .image("https://rickandmortyapi.com/api/character/avatar/2.jpeg")
                .episode(new ArrayList<>(
                        Arrays.asList(
                                "https://rickandmortyapi.com/api/episode/1",
                                "https://rickandmortyapi.com/api/episode/2")))
                .url("https://rickandmortyapi.com/api/character/2")
                .created(new Date())
                .build();
    }
}
