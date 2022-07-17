package com.atguigu.controller;

import com.atguigu.result.CommonResult;
import com.atguigu.service.UpdateAvatar;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author KyrieStudy
 * @version 1.0
 * @date 2022/6/7 22:33
 */
@RestController
@RequestMapping("/ossservice")
@CrossOrigin
public class OssController {

    @Autowired
    private UpdateAvatar updateAvatar;

    @ApiOperation(value = "文件上传")
    @PostMapping("/update")
    public CommonResult updateAvatar(@RequestParam("file") MultipartFile file){
        String url = updateAvatar.updateAvatarFile(file);
        return CommonResult.success().data("url",url);
    }
}
