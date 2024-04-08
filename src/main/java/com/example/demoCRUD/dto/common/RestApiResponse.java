package com.example.demoCRUD.dto.common;

import java.io.Serial;
import java.io.Serializable;

import com.example.demoCRUD.common.CustomErrorCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Builder
@Getter
@Setter
@AllArgsConstructor
@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL, content = JsonInclude.Include.NON_NULL)
public class RestApiResponse<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String errorCode;

    private String errorMessage;

    private T data;

    public static <T> ResponseEntity<RestApiResponse<T>> errorResponse(CustomErrorCode errorCode,
                                                                       HttpStatus status) {
        return ResponseEntity.status(status)
                .body(RestApiResponse.<T>builder()
                        .errorCode(errorCode.getCode())
                        .errorMessage(errorCode.getMessageTemplate())
                        .build());
    }

//    public static <T> RestApiResponse<T> of(final Throwable cause) {
//        return of(cause, null);
//    }

//    public static <T> RestApiResponse<T> of(final Throwable cause,HttpStatus status) {
//        return ResponseEntity.status(status)
//                .body(RestApiResponse.<T>builder()
//                        .errorCode("404")
//                        .errorMessage(cause.getMessage())
//                        .build());
//    }
}
