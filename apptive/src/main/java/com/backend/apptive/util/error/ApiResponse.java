package com.backend.apptive.util.error;

public class ApiResponse<T> {
    private String status;
    private T data;

    public ApiResponse(String status, T data) {
        this.status = status;
        this.data = data;
    }

    // 추가: 예외 처리용 생성자
    public ApiResponse(String status, String errorMessage) {
        this.status = status;
        this.data = (T) errorMessage;
    }

    public String getStatus() {
        return status;
    }

    public T getData() {
        return data;
    }
}
