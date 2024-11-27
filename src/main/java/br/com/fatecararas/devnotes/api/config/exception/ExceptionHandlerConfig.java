package br.com.fatecararas.devnotes.api.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandlerConfig {

    @ExceptionHandler({ ObjectNotFoundException.class })
    public ResponseEntity<ApiError> objectNotFoundException(Exception exception,
            HttpServletRequest request) {
        ApiError error = new ApiError(
                HttpStatus.NOT_FOUND.value(),
                "Recurso não localizado.",
                exception.getLocalizedMessage(),
                request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    //TODO: Incluir outras excecoes customizadas

    //TODO: Incluir BusinessRuleException.
}
