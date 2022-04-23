package com.mobdev.test.config.exception.handler;

import com.mobdev.test.config.exception.CustomException;
import com.mobdev.test.controller.model.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.ConnectException;
import java.time.ZoneId;
import java.time.ZonedDateTime;


@ControllerAdvice
public class GlobalExceptionHandler {

    private static final String ZONE_ID = "Chile/Continental";

    @ExceptionHandler(value = {CustomException.class})
    public ResponseEntity<Object> handleCustomException(CustomException ex){
        ErrorDto errorDto = new ErrorDto(
                ex.getMessage(),
                HttpStatus.valueOf(ex.getStatus()),
                getTime()
        );
        return new ResponseEntity<>(errorDto, errorDto.getHttpStatus());
    }

    @ExceptionHandler(value = {ConnectException.class})
    public ResponseEntity<Object> handleConnectException(ConnectException ex){
        ErrorDto errorDto = new ErrorDto(
                ex.getMessage(),
                HttpStatus.BAD_GATEWAY,
                getTime()
        );
        return new ResponseEntity<>(errorDto, errorDto.getHttpStatus());
    }

    private ZonedDateTime getTime(){
        return ZonedDateTime.now(ZoneId.of(ZONE_ID));
    }
}
