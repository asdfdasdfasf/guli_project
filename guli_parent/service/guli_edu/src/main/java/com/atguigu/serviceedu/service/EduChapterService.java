package com.atguigu.serviceedu.service;

import com.atguigu.serviceedu.entity.EduChapter;
import com.atguigu.serviceedu.entity.vo.ChapterVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author atguigu
 * @since 2022-06-10
 */
public interface EduChapterService extends IService<EduChapter> {

    /**
     * 查询所有的章节详细信息
     * @param id
     * @return
     */
    List<ChapterVo> queryAllChapterList(String id);

    /**
     * 删除章节信息
     * @param chapterId
     * @return
     */
    boolean deleteByChapterId(String chapterId);
}
