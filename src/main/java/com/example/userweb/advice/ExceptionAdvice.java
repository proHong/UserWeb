package com.example.userweb.advice;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;

import com.example.userweb.advice.Exception.CUserNotFoundException;
import com.example.userweb.domain.response.CommonResult;
import com.example.userweb.service.ResponseService;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestControllerAdvice
public class ExceptionAdvice {
    private final ResponseService responseService;

    @ExceptionHandler(CUserNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected CommonResult userNotFoundException(HttpServletRequest request, CUserNotFoundException e) {
        return responseService.getFailResult();
    }
}