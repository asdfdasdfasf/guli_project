package com.atguigu.serviceedu.controller;


import com.atguigu.result.CommonResult;
import com.atguigu.serviceedu.entity.vo.SubjectVo;
import com.atguigu.serviceedu.service.EduSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import java.util.List;

/**
 * 课程分类相关操作
 * @author atguigu
 * @since 2022-06-09
 */
@RestController
@RequestMapping("/serviceedu/subject")
@CrossOrigin
public class EduSubjectController {

    @Autowired
    private EduSubjectService eduSubjectService;

    /**
     * 上传课程分类Excel表
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public CommonResult uploadSubject(@RequestParam("file")MultipartFile file){
        eduSubjectService.saveSubject(file,eduSubjectService);
        return CommonResult.success();
    }

    /**
     * 获取所有的课程分类
     * @return
     */
    @GetMapping("/subjectAll")
    public CommonResult getAllSubject(){
        List<SubjectVo> subjectVoList=eduSubjectService.selectAllSubject();
        return CommonResult.success().data("list",subjectVoList);
    }
}

