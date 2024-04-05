package com.example.demoCRUD.common;

import lombok.*;

import java.util.stream.Stream;

@AllArgsConstructor
@Getter
public enum CustomErrorCode {
    E100("100", "System error"),
    E101("101", "Sample Error message"),
    E200("200", "Permission denied!"),
    E203("203", "Not found exception"),
    E201("201", "Missing parameters or fields"),
    E204("204", "Unauthorized"),
    E205("205", "The username or password is not match."),
    E206("206", "The user inactive"),
    E207("207", "The user already exists"),
    E208("208", "Token invalid"),
    E209("209", "The product already exists");

    private final String code;

    private final String messageTemplate;

    public static CustomErrorCode of(final String code) {
        return Stream.of(CustomErrorCode.values()).filter(errorCode -> errorCode.getCode().equals(code)).findFirst().orElse(null);
    }
}
