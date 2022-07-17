package com.atguigu.serviceedu.controller;

import com.atguigu.result.CommonResult;
import org.springframework.web.bind.annotation.*;

/**
 * @author KyrieStudy
 * @version 1.0
 * @date 2022/6/3 10:38
 */
@RestController
@RequestMapping("/serviceedu/user")
@CrossOrigin
public class UserLoginController {
    @GetMapping("/info")
    public CommonResult userInfo(){
        return CommonResult.success().data("name","Lucy")
                .data("avatar","")
                .data("introduction","myself")
                .data("roles","admin").data("avatar","http://cdn.u2.huluxia.com/g3/M00/29/B8/wKgBOVwKZOKAK4EiAACrtb6bkbE085.jpg");
    }

    @PostMapping("/login")
    public CommonResult userLogin(){
        return CommonResult.success().data("token","admin");
    }
}
