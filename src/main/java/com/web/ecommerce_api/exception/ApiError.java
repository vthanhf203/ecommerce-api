package com.web.ecommerce_api.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
@Getter
@Setter
public class ApiError {
    private Instant timestamp = Instant.now();
    private int status;
    private String error;
    private String message;
    private String path;
}
