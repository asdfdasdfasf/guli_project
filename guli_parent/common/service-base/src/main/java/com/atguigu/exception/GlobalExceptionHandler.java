package com.atguigu.exception;

import com.atguigu.result.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author KyrieStudy
 * @version 1.0
 * @date 2022/5/22 17:47
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(MyException.class)
    @ResponseBody
    public CommonResult error(MyException e){
        e.printStackTrace();
        log.error(ExceptionUtil.getMessage(e));
        return CommonResult.error().message(e.getMsg(),e.getCode());
    }
}
