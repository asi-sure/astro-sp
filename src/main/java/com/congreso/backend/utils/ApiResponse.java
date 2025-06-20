package com.congreso.backend.utils;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.Map;

@JsonPropertyOrder({"httpHeaders","httpStatusCode","message","otherParams","data","data2"})
public class ApiResponse<T> {
    private final org.springframework.http.HttpHeaders httpHeaders;
    private final int httpStatusCode;
    private final String message;
    private final T data;
    private final T data2;
    private final Map<String, Object> otherParams;

    private ApiResponse(ApiResponseBuilder builder) {
        this.httpHeaders = builder.httpHeaders;
        this.httpStatusCode = builder.httpStatusCode;
        this.message = builder.message;
        this.data = (T) builder.data;
        this.data2 = (T) builder.data2;
        this.otherParams = builder.otherParams;
    }

    public org.springframework.http.HttpHeaders getHttpHeaders() {
        return httpHeaders;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public T getData2() {
        return data2;
    }

    public Map<String, Object> getOtherParams() {
        return otherParams;
    }

    public static class ApiResponseBuilder<T> {

        private org.springframework.http.HttpHeaders httpHeaders = new org.springframework.http.HttpHeaders();
        private final int httpStatusCode;
        private final String message;
        private T data;

        private T data2;
        private Map<String, Object> otherParams = Collections.emptyMap();

        public ApiResponseBuilder(int httpStatusCode, String message) {
            this.httpStatusCode = httpStatusCode;
            this.message = message;
        }

        public ApiResponseBuilder<T> withHttpHeader(HttpHeaders httpHeader) {
            this.httpHeaders = httpHeader;
            return this;
        }

        public ApiResponseBuilder<T> withData(T data) {
            this.data = data;
            return this;
        }
        public ApiResponseBuilder<T> withData2(T data2) {
            this.data2 = data2;
            return this;
        }
        public ApiResponseBuilder<T> withOtherParams(Map<String, Object> otherParams) {
            this.otherParams = otherParams;
            return this;
        }

        public ResponseEntity<ApiResponse> build() {
            ApiResponse<T> apiResponse = new ApiResponse<>(this);
            return ResponseEntity.status(apiResponse.getHttpStatusCode()).headers(apiResponse.getHttpHeaders())
                    .body(apiResponse);
        }
    }
}
