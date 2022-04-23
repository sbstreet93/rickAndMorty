package com.mobdev.test.config.feign.decoder;

import com.google.common.base.Charsets;
import com.google.gson.Gson;
import com.mobdev.test.config.exception.CustomException;
import com.mobdev.test.client.model.ErrorServerDto;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FeignErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultErrorDecoder = new Default();
    private final String CUSTOM_ERROR = "Unrecognized Error";
    Gson gson = new Gson();

    @Override
    public Exception decode(String methodKey, Response response) {
        if(response.status() >= 400 && response.status() <= 499) {
            log.error("Status: " + response.status());
            return new CustomException(response.status(), getErrorMessage(response));
        }
        return defaultErrorDecoder.decode(methodKey, response);
    }

    private String getErrorMessage(Response response){
        String error;
        try {
            error = IOUtils.toString(response.body().asInputStream(), Charsets.UTF_8.toString());
            ErrorServerDto errorServerDto = gson.fromJson(error, ErrorServerDto.class);
            error = errorServerDto.getError();
        } catch (Exception e) {
            log.error(e.getMessage());
            error = CUSTOM_ERROR;
        }
        log.error("Error: " + error);
        return error;
    }
}
