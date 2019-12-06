package com.guli.common.handler;

import com.fasterxml.jackson.core.JsonParseException;
import com.guli.common.constants.ResultCodeEnum;
import com.guli.common.constants.vo.R;
import com.guli.common.exception.GuliException;
import com.guli.common.util.ExceptionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author kaixuan
 * @version 1.0
 * @date 2019/11/5 14:21
 * 统一异常处理器
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    /**
     * 异常处理方法
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e) {
        log.error(ExceptionUtil.getMessage(e));
        return R.error();
    }

    /**
     * json解析异常
     * @param e
     * @return
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public R error(JsonParseException e){
        log.error(ExceptionUtil.getMessage(e));
        return R.setResult(ResultCodeEnum.JSON_PARSE_ERROR);
    }

    @ExceptionHandler(GuliException.class)
    @ResponseBody
    public R error(GuliException e){
        log.error(ExceptionUtil.getMessage(e));
        return R.error().message(e.getMessage()).code(e.getCode());
    }



}
