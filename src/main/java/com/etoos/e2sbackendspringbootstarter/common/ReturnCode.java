package com.etoos.e2sbackendspringbootstarter.common;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum ReturnCode implements EnumCode {
    OK(0, "Success"),
    BAD_REQUEST(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());

    ReturnCode(final Integer code, final String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    Integer code;
    String message;

    // usage: ReturnCode.getCode(ReturnCode.OK)
    public static <T extends EnumCode> Integer getCode(T op) {
        return op.getCode();
    }

    // usage: ReturnCode.getMessage(ReturnCode.OK)
    public static <T extends EnumCode> String getMessage(T op) {
        return op.getMessage();
    }

}
