package com.example.demoCRUD.exception;

import com.example.demoCRUD.common.CustomErrorCode;
import lombok.*;
@Getter
public class CustomException extends RuntimeException {
    private static final String DEFAULT_MESSAGE = "An unexpected exception has occurred.";
    private static final CustomErrorCode DEFAULT_ERROR = CustomErrorCode.E100;

    private final CustomErrorCode error;

    public CustomException() {
        super(DEFAULT_MESSAGE);
        this.error = DEFAULT_ERROR;
    }

    public CustomException(final CustomErrorCode code) {
        super(code.getMessageTemplate());
        this.error = code;
    }

    public CustomException(final String code, final String message) {
        super(message);
        this.error = CustomErrorCode.of(code);
    }

    public CustomException(final String code, final String message, final Throwable cause) {
        super(message, cause);
        this.error = CustomErrorCode.of(code);
    }

    public CustomException(final String message, final Throwable cause) {
        super(message, cause);
        this.error = DEFAULT_ERROR;
    }

    public String getCode() {
        return this.error.getCode();
    }
}
