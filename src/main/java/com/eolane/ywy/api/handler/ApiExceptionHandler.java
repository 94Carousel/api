package com.eolane.ywy.api.handler;

import com.eolane.ywy.api.dto.ResultDTO;
import com.eolane.ywy.api.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@ControllerAdvice
public class ApiExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(ApiExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultDTO handler(HttpServletRequest req, Exception e) {
        log.error("【系统异常】{}", e.getMessage());
        return ResultUtil.error();
    }
}
