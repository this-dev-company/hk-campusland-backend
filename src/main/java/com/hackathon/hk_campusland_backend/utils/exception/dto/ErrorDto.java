package com.hackathon.hk_campusland_backend.utils.exception.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDto {
    private String code;
    private String message; 
}
