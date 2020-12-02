package com.github.zuihou.uzi.pet.config;

import com.github.zuihou.boot.handler.DefaultGlobalExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 柚子宠物码-全局异常处理
 *
 * @author zhaoyk
 * @date 2020-12-02
 */
@Configuration
@ControllerAdvice(annotations = {RestController.class, Controller.class})
@ResponseBody
public class PetExceptionConfiguration extends DefaultGlobalExceptionHandler {
}
