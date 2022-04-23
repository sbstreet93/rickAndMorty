package com.mobdev.test.service;

import com.mobdev.test.controller.model.OriginDto;

public interface LocationService {
    OriginDto getById(Integer id);
}
