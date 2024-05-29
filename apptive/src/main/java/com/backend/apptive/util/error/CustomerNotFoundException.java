package com.backend.apptive.util.error;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(String msg){
        super(msg);
    }

    // 추가: ApiResponse 반환하는 메서드
    public ApiResponse<String> toApiResponse() {
        return new ApiResponse<>("error", getMessage());
    }
}
