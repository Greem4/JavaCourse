package com.greem4.spring.http.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@Slf4j
@ControllerAdvice(basePackages = "com.greem4.spring.http.controller")
public class ControllerExceptionHandler /*extends ResponseEntityExceptionHandler*/ {

//    @ExceptionHandler(Exception.class)
//    public String handlerException(Exception exception) {
//        log.error("Failed to return response", exception);
//        return "error/error500";
//    }
}