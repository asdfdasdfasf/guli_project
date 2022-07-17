package com.atguigu.serviceedu.controller;


import com.atguigu.result.CommonResult;
import com.atguigu.serviceedu.entity.EduChapter;
import com.atguigu.serviceedu.entity.vo.ChapterVo;
import com.atguigu.serviceedu.service.EduChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author atguigu
 * @since 2022-06-10
 */
@RestController
@RequestMapping("/serviceedu/chapter")
@CrossOrigin
public class EduChapterController {

    @Autowired
    private EduChapterService chapterService;

    /**
     * 根据id获取章节详细信息
     *
     * @param id
     * @return
     */
    @GetMapping("/list/{id}")
    public CommonResult chapterList(@PathVariable("id") String id) {
        List<ChapterVo> chapterVoList = chapterService.queryAllChapterList(id);
        return CommonResult.success().data("chapterVoList", chapterVoList);
    }

    /**
     * 添加章节信息
     *
     * @param chapter
     * @return
     */
    @PostMapping("/addChapter")
    public CommonResult addChapter(@RequestBody EduChapter chapter) {
        boolean save = chapterService.save(chapter);
        if (save) {
            return CommonResult.success().message("添加章节信息成功", 20000);
        }
        return CommonResult.error();
    }

    /**
     * 更新章节信息
     * @param chapter
     * @return
     */
    @PostMapping("/updateChapter")
    public CommonResult updateChapter(@RequestBody EduChapter chapter) {
        boolean update = chapterService.updateById(chapter);
        if (update) {
            return CommonResult.success().message("更新章节信息成功", 20000);
        }
        return CommonResult.error();
    }

    /**
     * 删除章节信息，前提是章节下面没有小节才能够删除成功
     * @param chapterId
     * @return
     */
    @PostMapping("/deleteChapter/{chapterId}")
    public CommonResult deleteByChapterId(@PathVariable("chapterId") String chapterId) {
       boolean flag=chapterService.deleteByChapterId(chapterId);
       if(flag){
           return CommonResult.success().message("删除章节成功!",20000);
       }
       return CommonResult.error().message("章节存在小节无法进行删除",20001);
    }

    /**
     * 通过章节id获取章节信息
     * @param chapterId
     * @return
     */
    @GetMapping("/getChapter/{chapterId}")
    public CommonResult getChapterInfo(@PathVariable("chapterId")String chapterId){
        EduChapter chapterInfo = chapterService.getById(chapterId);
        return CommonResult.success().data("chapter",chapterInfo);
    }
}

