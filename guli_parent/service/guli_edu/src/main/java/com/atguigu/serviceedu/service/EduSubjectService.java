package com.atguigu.serviceedu.service;

import com.atguigu.serviceedu.entity.EduSubject;
import com.atguigu.serviceedu.entity.vo.SubjectVo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author atguigu
 * @since 2022-06-09
 */
public interface EduSubjectService extends IService<EduSubject> {

    /**
     * 保存课程文件
     * @param file
     * @param eduSubjectService
     */
    void saveSubject(MultipartFile file, EduSubjectService eduSubjectService);

    /**
     * 获取所有课程分类信息
     * @return
     */
    List<SubjectVo> selectAllSubject();
}
