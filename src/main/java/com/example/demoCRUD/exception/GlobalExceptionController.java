package com.example.demoCRUD.exception;

import com.example.demoCRUD.common.CustomErrorCode;
import com.example.demoCRUD.dto.common.RestApiResponse;
import com.example.demoCRUD.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//extends ResponseEntityExceptionHandler
@RestControllerAdvice
public class GlobalExceptionController  {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> handleSystemException(CustomException customException) {
        CustomErrorCode customErrorCode = customException.getError();
        return RestApiResponse.errorResponse(customErrorCode, HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(NoHandlerFoundException.class)
//    public ResponseEntity<?> handleNoHandlerFoundException(NoHandlerFoundException  ex) {
//        return RestApiResponse.errorResponse(customErrorCode, HttpStatus.BAD_REQUEST);
//    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return RestApiResponse.errorResponse(CustomErrorCode.E201, HttpStatus.BAD_REQUEST);

    }
}
