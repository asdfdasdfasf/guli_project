package com.atguigu.serviceedu.service;

import com.atguigu.result.CommonResult;
import com.atguigu.serviceedu.entity.EduTeacher;
import com.atguigu.serviceedu.entity.vo.TeacherVo;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author atguigu
 * @since 2022-05-19
 */
public interface EduTeacherService extends IService<EduTeacher> {
    /**
     * 分页条件查询讲师
     * @param pageNo current page number
     * @param limit  limit data
     * @param teacherVo query condition
     * @return
     */
    CommonResult queryTeacherByCondition(Long pageNo, Long limit, TeacherVo teacherVo);
}
