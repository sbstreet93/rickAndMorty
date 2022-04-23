package com.mobdev.test.config.mapper;

import com.mobdev.test.controller.model.OriginDto;
import com.mobdev.test.client.model.LocationServerDto;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface LocationMapper {
    OriginDto toOriginDto(LocationServerDto locationServerDto);
}
