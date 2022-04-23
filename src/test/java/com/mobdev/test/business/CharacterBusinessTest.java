package com.mobdev.test.business;

import com.mobdev.test.business.impl.CharacterBusinessImpl;
import com.mobdev.test.controller.model.CharacterDto;
import com.mobdev.test.controller.model.OriginDto;
import com.mobdev.test.service.CharacterService;
import com.mobdev.test.service.LocationService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;

import static com.mobdev.test.util.Util.getLocationIdByUrl;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(MockitoJUnitRunner.class)
public class CharacterBusinessTest {
    @Autowired
    private MockMvc mockMvc;

    @Mock
    private CharacterService characterService;
    @Mock
    private LocationService locationService;
    @InjectMocks
    private CharacterBusinessImpl characterBusiness;

    private static final Integer CHARACTER_ID = 1;
    private static final Integer ORIGIN_ID = 1;

    @Before
    public void init()
    {
        Mockito.
                when(locationService.getById(Mockito.anyInt()))
                .thenReturn(getOriginDto());
        Mockito.
                when(characterService.getById(Mockito.anyInt()))
                .thenReturn(getCharacterDto());
        mockMvc = standaloneSetup(characterBusiness).build();
    }

    @Test
    public void getById() {
        CharacterDto characterDto = characterBusiness.getById(CHARACTER_ID);
        Assert.assertTrue(characterDto.getId() == getCharacterDto().getId());
        Assert.assertTrue(getLocationIdByUrl(getOriginDto().getUrl()) == ORIGIN_ID);
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
