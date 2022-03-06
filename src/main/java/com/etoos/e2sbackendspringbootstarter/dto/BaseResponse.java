package com.etoos.e2sbackendspringbootstarter.dto;

import com.etoos.e2sbackendspringbootstarter.common.ReturnCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.lang.Nullable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse<T> {

    private Integer code;

    private String message;

    @Nullable
    T value;

    public static <T> BaseResponse<T> success() {
        return new BaseResponse<>(ReturnCode.OK.getCode(), ReturnCode.OK.getMessage(), null);
    }

    public static <T> BaseResponse<T> success(@Nullable final T resData) {
        return new BaseResponse<>(ReturnCode.OK.getCode(), ReturnCode.OK.getMessage(), resData);
    }

    public static <T> BaseResponse<T> from(final ReturnCode code, final String message) {
        return new BaseResponse<>(code.getCode(), message, null);
    }

    public static <T> BaseResponse<T> from(final ReturnCode code, final String message, final T resData) {
        return new BaseResponse<>(code.getCode(), message, resData);
    }
}
