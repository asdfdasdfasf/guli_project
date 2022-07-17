package com.atguigu.serviceedu.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.atguigu.exception.MyException;
import com.atguigu.serviceedu.entity.EduSubject;
import com.atguigu.serviceedu.entity.excel.ExcelSubject;
import com.atguigu.serviceedu.service.EduSubjectService;
import com.atguigu.serviceedu.service.EduTeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

/**
 * @author KyrieStudy
 * @version 1.0
 * @date 2022/6/9 15:57
 */
public class ExcelListener implements ReadListener<ExcelSubject> {

    private EduSubjectService eduSubjectService;

    /**
     * 传入servcie用于操作数据库
     * @param eduTeacherService
     */
    public ExcelListener(EduSubjectService eduTeacherService) {
        this.eduSubjectService=eduTeacherService;
    }


    /**
     * 查询二级分类是否存在
     * @param title
     * @param parentId
     * @return
     */
    private EduSubject checkSecondLevelSubject(String title, String parentId) {
        QueryWrapper<EduSubject> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("title",title);
        queryWrapper.eq("parent_id",parentId);
        EduSubject eduSubject = eduSubjectService.getOne(queryWrapper);
        return eduSubject;
    }

    /**
     * 查询一级分类是否存在
     * @param title
     * @return
     */
    private EduSubject checkFirstLevelSubject(String title) {
       QueryWrapper<EduSubject> wrapper=new QueryWrapper();
       wrapper.eq("title",title);
       wrapper.eq("parent_id","0");
        return eduSubjectService.getOne(wrapper);
    }


    /**
     * 读取每一行数据
     * @param excelSubject
     * @param analysisContext
     */
    @Override
    public void invoke(ExcelSubject excelSubject, AnalysisContext analysisContext) {
        if(excelSubject==null){
            throw new MyException(555,"Excel数据异常");
        }
        //检查一级分类是否已经存在
        String title=excelSubject.getFirstLevelSubject();
        EduSubject firstSubject=checkFirstLevelSubject(title);
        if(firstSubject==null){
            firstSubject=new EduSubject();
            firstSubject.setTitle(title);
            firstSubject.setParentId("0");
            eduSubjectService.save(firstSubject);
        }
        String parentId=firstSubject.getId();
        //检查二级分类是否已经存在
        EduSubject secondSubject=checkSecondLevelSubject(title,parentId);
        //如果不存在设置相关属性添加到数据库中
        if(secondSubject==null){
            secondSubject=new EduSubject();
            secondSubject.setParentId(parentId);
            secondSubject.setTitle(excelSubject.getSecondLevelSubject());
            eduSubjectService.save(secondSubject);
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
