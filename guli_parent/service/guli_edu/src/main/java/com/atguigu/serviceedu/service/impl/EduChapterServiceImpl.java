package com.atguigu.serviceedu.service.impl;

import com.atguigu.serviceedu.entity.EduChapter;
import com.atguigu.serviceedu.entity.EduVideo;
import com.atguigu.serviceedu.entity.vo.ChapterVo;
import com.atguigu.serviceedu.entity.vo.VideoVo;
import com.atguigu.serviceedu.mapper.EduChapterMapper;
import com.atguigu.serviceedu.service.EduChapterService;
import com.atguigu.serviceedu.service.EduVideoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author atguigu
 * @since 2022-06-10
 */
@Service
public class EduChapterServiceImpl extends ServiceImpl<EduChapterMapper, EduChapter> implements EduChapterService {

    @Autowired
    private EduVideoService videoService;

    /**
     * 查询所有章节详细信息
     *
     * @param id
     * @return
     */
    @Override
    public List<ChapterVo> queryAllChapterList(String id) {
        //1. 根据course_id 查询所有的章节信息
        QueryWrapper<EduChapter> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("course_id", id);
        List<EduChapter> list = this.list(queryWrapper);
        List<ChapterVo> result = new ArrayList<>();
        list.forEach(EduChapter -> {
            ChapterVo vo = new ChapterVo();
            BeanUtils.copyProperties(EduChapter, vo);
            //2. 根据章节id查询小节信息
            String chapterId = EduChapter.getId();
            QueryWrapper<EduVideo> chapterWrapper = new QueryWrapper<>();
            chapterWrapper.eq("chapter_id", chapterId);
            List<EduVideo> eduVideoList = videoService.list(chapterWrapper);
            List<VideoVo> voList = new ArrayList<>();
            eduVideoList.forEach(eduVideo -> {
                VideoVo videoVo = new VideoVo();
                BeanUtils.copyProperties(eduVideo, videoVo);
                voList.add(videoVo);
            });
            vo.setVideoVoList(voList);
            result.add(vo);
        });
        return result;
    }

    /**
     * 根据章节id删除章节信息
     * 删除逻辑为章节下面有小节的时候不能删除0
     *
     * @param chapterId
     * @return
     */
    @Override
    public boolean deleteByChapterId(String chapterId) {
        //根据章节id查询是否存在小节信息
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("chapter_id", chapterId);
        int count = videoService.count(queryWrapper);
        if (count > 0) {
            //存在小节无法进行删除
            return false;
        }
        int deleteCount = baseMapper.deleteById(chapterId);
        return deleteCount>0;
    }
}
