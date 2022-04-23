package com.mobdev.test.controller;

import com.mobdev.test.business.CharacterBusiness;
import com.mobdev.test.controller.model.CharacterDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("rickAndMorty/character")
@Api(value = "Character controller")
public class CharacterController {

    @Autowired
    CharacterBusiness business;

    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get reasons from backlog")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "success", response = CharacterDto.class),
            @ApiResponse(code = 400, message = "Bad Request/Invalid Arguments"),
            @ApiResponse(code = 404, message = "Character does not found"),
            @ApiResponse(code = 500, message = "Internal errors"),
    })
    public ResponseEntity<Object> getById(@PathVariable Integer id){
        return new ResponseEntity<>(business.getById(id), HttpStatus.OK);
    }
}