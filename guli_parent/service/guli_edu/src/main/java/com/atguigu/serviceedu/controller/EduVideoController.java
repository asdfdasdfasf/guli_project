package com.atguigu.serviceedu.controller;


import com.atguigu.result.CommonResult;
import com.atguigu.serviceedu.entity.EduVideo;
import com.atguigu.serviceedu.service.EduVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author atguigu
 * @since 2022-06-10
 */
@RestController
@RequestMapping("/serviceedu/video")
@CrossOrigin
public class EduVideoController {
    @Autowired
    private EduVideoService eduVideoService;

    /**
     * 添加小节信息
     * @param eduVideo
     * @return
     */
    @PostMapping("/addVideo")
    public CommonResult addVideo(@RequestBody EduVideo eduVideo){
        boolean result = eduVideoService.save(eduVideo);
        return result?CommonResult.success():CommonResult.error();
    }

    /**
     * 删除小节信息
     * @param videoId
     * @return
     */
    // TODO: 2022/6/23 后面删除的时候删除了小节之前需要先删除对应的视频
    @PostMapping("/deleteVideo/{videoId}")
    public CommonResult deleteVideo(@PathVariable("videoId")String videoId){
        boolean flag = eduVideoService.removeById(videoId);
        return flag?CommonResult.success():CommonResult.error();
    }

    /**
     * 根据id更新小节的信息
     * @param eduVideo
     * @return
     */
    @PostMapping("/updateVideo")
    public CommonResult updateVideo(@RequestBody EduVideo eduVideo){
        boolean update = eduVideoService.updateById(eduVideo);
        return update?CommonResult.success():CommonResult.error();
    }

    /**
     * 根据id查询小节信息
     * @param videoId
     * @return
     */
    @GetMapping("/getVideo/{videoId}")
    public CommonResult getVideo(@PathVariable("videoId") String videoId){
        EduVideo byId = eduVideoService.getById(videoId);
        return CommonResult.success().data("video",byId);
    }

}

