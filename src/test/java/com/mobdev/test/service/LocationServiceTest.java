package com.mobdev.test.service;

import com.mobdev.test.controller.model.OriginDto;
import com.mobdev.test.client.LocationControllerClient;
import com.mobdev.test.client.model.LocationServerDto;
import com.mobdev.test.config.mapper.LocationMapper;
import com.mobdev.test.service.impl.LocationServiceImpl;
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

import static com.mobdev.test.util.Util.getLocationIdByUrl;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(MockitoJUnitRunner.class)
public class LocationServiceTest {
    @Autowired
    private MockMvc mockMvc;
    @Spy
    private LocationMapper locationMapper = Mappers.getMapper(LocationMapper.class);
    @Mock
    private LocationControllerClient locationControllerClient;
    @InjectMocks
    private LocationServiceImpl locationService;

    private static final Integer ORIGIN_ID = 20;

    @Before
    public void init()
    {
        Mockito.
                when(locationControllerClient.getById(Mockito.anyInt()))
                .thenReturn(getCharacterServerDto());
        mockMvc = standaloneSetup(locationService).build();
    }

    @Test
    public void getById() {
        OriginDto originDto = locationService.getById(ORIGIN_ID);
        Assert.assertTrue(getLocationIdByUrl(originDto.getUrl()) == ORIGIN_ID);
    }

    public LocationServerDto getCharacterServerDto(){
        return LocationServerDto.builder()
                .id(ORIGIN_ID)
                .name("Earth (Replacement Dimension)")
                .type("Planet")
                .dimension("Replacement Dimension")
                .residents(new ArrayList<>(
                        Arrays.asList(
                                "https://rickandmortyapi.com/api/character/3",
                                "https://rickandmortyapi.com/api/character/4")))
                .url("https://rickandmortyapi.com/api/location/20")
                .created(new Date())
                .build();
    }
}
