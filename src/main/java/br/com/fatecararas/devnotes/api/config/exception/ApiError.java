package br.com.fatecararas.devnotes.api.config.exception;

import java.time.LocalDateTime;

import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
public class ApiError {
    private final String timezone = LocalDateTime.now().toString();
    private Integer statusCode;
    private String error;
    private String message;
    private String path;

    public ApiError(Integer statusCode, String error, String message, String path) {
        this.statusCode = statusCode;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public ApiError() {
    }
}
