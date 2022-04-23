package com.mobdev.test.client;

import com.mobdev.test.config.feign.CharacterControllerClientConfig;
import com.mobdev.test.client.model.LocationServerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@FeignClient(value = "locationcontroller", url = "${service.rick.and.morty.location.url}",
        configuration = CharacterControllerClientConfig.class)
public interface LocationControllerClient {
    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    LocationServerDto getById(@PathVariable Integer id);
}

