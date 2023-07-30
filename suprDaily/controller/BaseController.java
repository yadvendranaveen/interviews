package com.dm.mesh.jiraplugin.suprDaily.controller;

import com.dm.mesh.jiraplugin.suprDaily.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author yadvendranaveen
 * Date: 2021-01-22
 */

public class BaseController {

    <T> ResponseEntity<ResponseDto<T>> response(String message, T obj, HttpStatus httpStatus) {
        ResponseDto<T> responseDto = new ResponseDto<>(message, obj);
        return ResponseEntity.status(httpStatus).body(responseDto);
    }

    <T> ResponseEntity<ResponseDto<T>> response(String message, T obj) {
        return response(message, obj, HttpStatus.OK);
    }
}
