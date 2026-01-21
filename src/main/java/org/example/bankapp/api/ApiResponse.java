package org.example.bankapp.api;

import org.example.bankapp.dto.ApiErrorResponse;

public class ApiResponse<T> {
    private T data;
    private ApiErrorResponse errors;
    private boolean success;

    private ApiResponse(boolean success, T data, ApiErrorResponse errors) {
        this.success = success;
        this.data = data;
        this.errors = errors;
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(true, data, null);
    }

    public static <T> ApiResponse<T> erroor(ApiErrorResponse errors) {
        return new ApiResponse<>(false, null, errors);
    }

    public T getData() {
        return data;
    }

    public ApiErrorResponse getErrors() {
        return errors;
    }

    public boolean isSuccess() {
        return success;
    }

}
