package com.congreso.backend.exception;

import com.congreso.backend.exception.type.BadRequestException;
import com.congreso.backend.exception.type.ResourceNotFoundException;
import com.congreso.backend.exception.util.ApiException;
import com.congreso.backend.exception.util.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ApiException handlerException(Exception ex) {
        logger.error("Se produjo una excepción:", ex);
        ApiException exception = new ApiException();
        exception.setErrorMessage(ex.getMessage());
        exception.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        exception.setZonedDateTime(ZonedDateTime.now());
        return exception;
    }

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public ApiResponse handleThrowable(Throwable ex, HttpServletRequest request) {
        logger.error("Se produjo una excepción no manejada:", ex);
        ApiResponse response = new ApiResponse("Se produjo una excepción no manejada", request.getRequestURI());
        return response;
    }
    @ExceptionHandler(HttpMessageNotReadableException.class) //by oam
    @ResponseBody
    public ApiResponse HttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        logger.error("Malformed or invalid JSON:", ex);
        ApiResponse response = new ApiResponse("Malformed or invalid JSON", ex.getMostSpecificCause().getMessage());
        return response;
    }
    @ExceptionHandler(BadSqlGrammarException.class) //by oam
    @ResponseBody
    public ApiResponse BadSqlGrammarException(BadSqlGrammarException ex) {
        logger.error("Error de SQL mal escrita:", ex);
        ApiResponse response = new ApiResponse("Error de SQL mal escrita", ex.getMostSpecificCause().getMessage());
        return response;
    }
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseBody
    public ApiResponse handleNoHandlerFoundException(NoHandlerFoundException ex, HttpServletRequest request) {
        logger.error("No se encontró el manejador para la solicitud:", ex);
        ApiResponse response = new ApiResponse("No se encontró el manejador para la solicitud", request.getRequestURI());
        return response;
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ApiException handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        logger.warn("Excepción de validación de entrada:", ex);
        Map<String, String> validationErrors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            validationErrors.put(fieldName, errorMessage);
        });
        ApiException exception = new ApiException();
        exception.setErrorMessage(String.format("%s : %s", "Validation failed", validationErrors.toString()));
        exception.setStatusCode(HttpStatus.BAD_REQUEST.value());
        exception.setZonedDateTime(ZonedDateTime.now());
        return exception;
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseBody
    public ApiException handleResourceNotFoundException(ResourceNotFoundException ex) {
        logger.warn("Recurso no encontrado:", ex);
        ApiException exception = new ApiException();
        exception.setErrorMessage(ex.getMessage());
        exception.setStatusCode(HttpStatus.NOT_FOUND.value());
        exception.setZonedDateTime(ZonedDateTime.now());
        return exception;
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseBody
    public ApiException handlerBadRequestException(BadRequestException ex) {
        logger.warn("Solicitud incorrecta al servidor:", ex);
        ApiException exception = new ApiException();
        exception.setErrorMessage(ex.getMessage());
        exception.setStatusCode(HttpStatus.BAD_REQUEST.value());
        exception.setZonedDateTime(ZonedDateTime.now());
        return exception;
    }
}
