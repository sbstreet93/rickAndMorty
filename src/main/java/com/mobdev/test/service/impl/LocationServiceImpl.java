package com.mobdev.test.service.impl;

import com.mobdev.test.controller.model.OriginDto;
import com.mobdev.test.client.LocationControllerClient;
import com.mobdev.test.client.model.LocationServerDto;
import com.mobdev.test.config.mapper.LocationMapper;
import com.mobdev.test.service.LocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LocationServiceImpl implements LocationService {
    LocationControllerClient client;
    LocationMapper mapper;

    @Autowired
    public LocationServiceImpl(LocationControllerClient client,
                                LocationMapper mapper
    ) {
        this.client = client;
        this.mapper = mapper;
    }

    @Override
    public OriginDto getById(Integer id){
        LocationServerDto locationServerDto = client.getById(id);
        OriginDto originDto = mapper.toOriginDto(locationServerDto);
        return originDto;
    }
}
