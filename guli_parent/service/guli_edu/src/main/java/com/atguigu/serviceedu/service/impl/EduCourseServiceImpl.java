package com.atguigu.serviceedu.service.impl;

import com.atguigu.serviceedu.entity.EduCourse;
import com.atguigu.serviceedu.entity.EduCourseDescription;
import com.atguigu.serviceedu.entity.vo.CourseInfoVo;
import com.atguigu.serviceedu.mapper.EduCourseMapper;
import com.atguigu.serviceedu.service.EduCourseDescriptionService;
import com.atguigu.serviceedu.service.EduCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author atguigu
 * @since 2022-06-10
 */
@Service
@Transactional
public class EduCourseServiceImpl extends ServiceImpl<EduCourseMapper, EduCourse> implements EduCourseService {

    @Autowired
    private EduCourseDescriptionService eduCourseDescriptionService;

    /**
     * 添加课程信息，成功返回true，失败返回false
     *
     * @param courseInfoVo
     * @return
     */
    @Override
    public String addCourseInfo(CourseInfoVo courseInfoVo) {
        //1. 向edu_course表中插入相关的信息
        EduCourse eduCourse = new EduCourse();
        //拷贝属性
        BeanUtils.copyProperties(courseInfoVo, eduCourse);
        //3.插入数据
        boolean result1 = this.save(eduCourse);
        //4.向edu_course_description表中插入评论信息
        EduCourseDescription description = new EduCourseDescription();
        description.setDescription(courseInfoVo.getDescription());
        description.setId(eduCourse.getId());
        boolean result2 = eduCourseDescriptionService.save(description);
        if (result2 && result1) {
            return eduCourse.getId();
        }
        return "";
    }

    /**
     * 根据课程id查询课程信息
     *
     * @param courseId
     * @return
     */
    @Override
    public CourseInfoVo getCourseInfo(String courseId) {
        //查询课程信息
        EduCourse eduCourse = baseMapper.selectById(courseId);
        CourseInfoVo vo = new CourseInfoVo();
        //属性赋值
        BeanUtils.copyProperties(eduCourse, vo);
        //查询课程描述信息
        EduCourseDescription courseDescription = eduCourseDescriptionService.getById(courseId);
        vo.setDescription(courseDescription.getDescription());
        return vo;
    }

    /**
     * 更新课程信息
     *
     * @param courseInfoVo
     */
    @Override
    public void updateCourseInfo(CourseInfoVo courseInfoVo) {
        //更新eud_course表
        EduCourse eduCourse = new EduCourse();
        BeanUtils.copyProperties(courseInfoVo, eduCourse);
        this.updateById(eduCourse);
        //更新edu_description表
        EduCourseDescription description=new EduCourseDescription();
        description.setId(eduCourse.getId());
        description.setDescription(courseInfoVo.getDescription());
        this.eduCourseDescriptionService.updateById(description);
    }
}
