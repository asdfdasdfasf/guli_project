package com.atguigu.serviceedu.controller;


import com.atguigu.result.CommonResult;
import com.atguigu.serviceedu.entity.vo.CourseInfoVo;
import com.atguigu.serviceedu.service.EduCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.concurrent.CompletableFuture;

/**
 * 课程添加相关模块
 * @author atguigu
 * @since 2022-06-10
 */
@RestController
@RequestMapping("/serviceedu/edu-course")
@CrossOrigin
public class EduCourseController {

    @Autowired
    private EduCourseService eduCourseService;

    /**
     * 添加课程信息
     * @param courseInfoVo
     * @return
     */
    @PostMapping("/addCourse")
    public CommonResult addCourse(@RequestBody CourseInfoVo courseInfoVo){
       String result=eduCourseService.addCourseInfo(courseInfoVo);
        return result.equals("")?CommonResult.error():CommonResult.success().data("courseId",result);
    }

    /**
     * 根据课程id查询课程信息
     * @param courseId
     * @return
     */
    @GetMapping("/getCourseInfo/{courseId}")
    public CommonResult getCourseInfo(@PathVariable("courseId") String courseId){
        CourseInfoVo courseInfoVo=eduCourseService.getCourseInfo(courseId);
        return CommonResult.success().data("courseInfoVo",courseInfoVo);
    }

    /**
     * 更新课程信息
     * @param courseInfoVo
     * @return
     */
    @PostMapping("/updateCourseInfo")
    public CommonResult updateCourseInfo(@RequestBody CourseInfoVo courseInfoVo){
        eduCourseService.updateCourseInfo(courseInfoVo);
        return CommonResult.success();
    }
}

