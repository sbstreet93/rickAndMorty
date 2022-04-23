package com.mobdev.test.controller;

import com.mobdev.test.business.CharacterBusiness;
import com.mobdev.test.controller.model.CharacterDto;
import com.mobdev.test.controller.model.OriginDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;

@WebMvcTest(value = CharacterController.class)
@RunWith(SpringRunner.class)
public class CharacterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CharacterBusiness characterBusiness;

    private static final Integer CHARACTER_ID = 1;
    private static final Integer ORIGIN_ID = 1;

    @Test
    public void getById() throws Exception {
        Mockito
                .when(characterBusiness.getById(Mockito.anyInt()))
                .thenReturn(getCharacterDto());

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/rickAndMorty/character/" + CHARACTER_ID)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse().getContentAsString());
        String expected = "{\"id\":1,\"name\":\"Rick Sanchez\",\"status\":\"Alive\"}";

        JSONAssert.assertEquals(
                expected,
                result.getResponse().getContentAsString(),
                JSONCompareMode.LENIENT);
    }

    private CharacterDto getCharacterDto(){
        return CharacterDto.builder()
                .id(CHARACTER_ID)
                .name("Rick Sanchez")
                .status("Alive")
                .species("Human")
                .type("")
                .episodeCount(51)
                .originId(ORIGIN_ID)
                .origin(getOriginDto())
                .build();
    }

    private OriginDto getOriginDto(){
        return OriginDto.builder()
                .name("Earth (C-137)")
                .url("https://rickandmortyapi.com/api/location/1")
                .dimension("Dimension C-137")
                .residents(new ArrayList<>(
                        Arrays.asList(
                                "https://rickandmortyapi.com/api/character/3",
                                "https://rickandmortyapi.com/api/character/4",
                                "https://rickandmortyapi.com/api/character/5",
                                "https://rickandmortyapi.com/api/character/9")
                ))
                .build();
    }
}
