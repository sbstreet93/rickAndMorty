package com.mobdev.test.controller.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OriginDto {
    private String name;
    private String url;
    private String dimension;
    private List<String> residents;
}
