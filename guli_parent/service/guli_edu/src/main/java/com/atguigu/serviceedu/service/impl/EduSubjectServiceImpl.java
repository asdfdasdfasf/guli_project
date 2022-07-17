package com.atguigu.serviceedu.service.impl;

import com.alibaba.excel.EasyExcel;
import com.atguigu.serviceedu.entity.EduSubject;
import com.atguigu.serviceedu.entity.excel.ExcelSubject;
import com.atguigu.serviceedu.entity.excel.SecondLevel;
import com.atguigu.serviceedu.entity.vo.SubjectVo;
import com.atguigu.serviceedu.listener.ExcelListener;
import com.atguigu.serviceedu.mapper.EduSubjectMapper;
import com.atguigu.serviceedu.service.EduSubjectService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.ServiceConfigurationError;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author atguigu
 * @since 2022-06-09
 */
@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {

    /**
     * 保存课程文件
     * @param file
     * @param eduSubjectService
     */
    @Override
    public void saveSubject(MultipartFile file, EduSubjectService eduSubjectService) {
        try {
            InputStream inputStream=file.getInputStream();
            EasyExcel.read(inputStream, ExcelSubject.class,new ExcelListener(this)).sheet().doRead();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取所有课程分类信息
     * @return
     */
    @Override
    public List<SubjectVo> selectAllSubject() {
        //创建返回结果集合
        List<SubjectVo> result=new ArrayList<>();;
        //1. 查询所有一级分类信息
        QueryWrapper<EduSubject> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("parent_id","0");
        List<EduSubject> list = this.list(queryWrapper);
        //2. 遍历一级分类信息，查询对应的二级分类信息
        list.forEach(EduSubject->{
            SubjectVo vo=new SubjectVo();
            QueryWrapper<EduSubject> secondWrapper=new QueryWrapper<>();
            vo.setId(EduSubject.getId());
            vo.setTitle(EduSubject.getTitle());
            secondWrapper.eq("parent_id",EduSubject.getId());
            List<EduSubject> eduSubjectList = this.list(secondWrapper);
            //创建二级目录集合
            List<SecondLevel> secondLevels=new ArrayList<>();
            eduSubjectList.forEach((secondLevel)->{
                SecondLevel mySecond=new SecondLevel();
                BeanUtils.copyProperties(secondLevel,mySecond);
                secondLevels.add(mySecond);
            });
            vo.setChildren(secondLevels);
            result.add(vo);
        });

        return result;
    }
}
