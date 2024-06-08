package com.anicaaz.securitydemo.controller;

import com.anicaaz.securitydemo.model.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/open-api")
public class TestDemoController {

    @RequestMapping("/bussiness-a")
    public Result bussinessA() {
        return new Result("OK", "接口正常", null);
    }

    @RequestMapping("/bussiness-b")
    public Result bussinessB() {
        throw new RuntimeException("cnn");
    }
}
