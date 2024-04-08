package com.example.demoCRUD.exception;

import com.example.demoCRUD.common.CustomErrorCode;
import com.example.demoCRUD.dto.common.RestApiResponse;
import com.example.demoCRUD.exception.CustomException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class GlobalExceptionController extends ResponseEntityExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> handleSystemException(CustomException customException) {
        CustomErrorCode customErrorCode = customException.getError();
        return RestApiResponse.errorResponse(customErrorCode, HttpStatus.BAD_REQUEST);
    }

    //    @ExceptionHandler(NoHandlerFoundException.class)
//    public ResponseEntity<?> handleNoHandlerFoundException(NoHandlerFoundException  ex) {
//        return RestApiResponse.errorResponse(customErrorCode, HttpStatus.BAD_REQUEST);
//    }
    @Override
    //@ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<?> handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
//        return RestApiResponse.errorResponse(CustomErrorCode.E201, HttpStatus.BAD_REQUEST);
//
//    }
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(RestApiResponse.of(CustomErrorCode.E201));
    }
}
