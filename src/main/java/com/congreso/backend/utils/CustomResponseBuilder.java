package com.congreso.backend.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CustomResponseBuilder {
    public ResponseEntity<ApiResponse> buildResponse(
            HttpHeaders httpHeader, int httpStatusCode, String message, Object data, Map<String, Object> otherParams) {
        return new ApiResponse.ApiResponseBuilder <> (httpStatusCode, message).withHttpHeader(httpHeader)
                .withData(data).withOtherParams(otherParams).build();
    }
    //ESTE ES EL INDICADO
    public ResponseEntity <ApiResponse> buildResponse(
            int httpStatusCode, String message, Object data, Map <String, Object> otherParams) {
        return new ApiResponse.ApiResponseBuilder <> (httpStatusCode, message)
                .withData(data).withOtherParams(otherParams).build();
    }

    //ESTE ES EL INDICADO copy
    public ResponseEntity <ApiResponse> buildResponse(
            int httpStatusCode, String message, Object data, Object data2, Map <String, Object> otherParams) {
        return new ApiResponse.ApiResponseBuilder <> (httpStatusCode, message)
                .withData(data).withData2(data2).withOtherParams(otherParams).build();
    }

    public ResponseEntity <ApiResponse> buildResponse(
            int httpStatusCode, String message, Map <String, Object> otherParams) {
        return new ApiResponse.ApiResponseBuilder <> (httpStatusCode, message)
                .withOtherParams(otherParams).build();
    }

    public ResponseEntity <ApiResponse> buildResponse(
            int httpStatusCode, String message) {
        return new ApiResponse.ApiResponseBuilder <> (httpStatusCode, message).build();
    }

    public ResponseEntity <ApiResponse> buildResponse(
            HttpHeaders httpHeader, int httpStatusCode, String message, Object data) {
        return new ApiResponse.ApiResponseBuilder <> (httpStatusCode, message)
                .withHttpHeader(httpHeader).withData(data).build();
    }

    public ResponseEntity <ApiResponse> buildResponse(
            HttpHeaders httpHeader, int httpStatusCode, String message, Map <String, Object> otherParams) {
        return new ApiResponse.ApiResponseBuilder <> (httpStatusCode, message)
                .withHttpHeader(httpHeader).withOtherParams(otherParams).build();
    }

    public ResponseEntity <ApiResponse> buildResponse(
            HttpHeaders httpHeader, int httpStatusCode, String message) {
        return new ApiResponse.ApiResponseBuilder <> (httpStatusCode, message)
                .withHttpHeader(httpHeader).build();
    }

    public ResponseEntity <ApiResponse> buildResponse(
            int httpStatusCode, String message, Object data
                                                     ) {
        return new ApiResponse.ApiResponseBuilder <> (httpStatusCode, message)
                .withData(data).build();
    }



}
