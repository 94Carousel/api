package com.eolane.ywy.api.util;

import com.eolane.ywy.api.dto.ResultDTO;

public class ResultUtil<T> {
    private static final int SUCCESS_CODE = 0;
    private static final int FAILD_CODE = -1;
    private static final String SUCCESS_MESSAGE = "success";
    private static final String FAILED_MESSAGE = "failed";
    private int code;
    private String message;
    private T data;

    public static ResultDTO success(Object data) {
        return new ResultDTO<>(SUCCESS_CODE, SUCCESS_MESSAGE, data);
    }

    public static ResultDTO success() {
        return success(new Object());
    }

    public static ResultDTO error() {
        return new ResultDTO<>(FAILD_CODE, FAILED_MESSAGE, new Object());
    }
}
