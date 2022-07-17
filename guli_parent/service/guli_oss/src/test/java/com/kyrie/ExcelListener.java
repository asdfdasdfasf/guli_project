package com.kyrie;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.read.listener.ReadListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author KyrieStudy
 * @version 1.0
 * @date 2022/6/9 14:51
 */
public class ExcelListener implements ReadListener<Student> {
    private List<Student> studentList=new ArrayList<>();
    /**
     * 获取表头的信息
     * @param headMap
     * @param context
     */
    @Override
    public void invokeHead(Map<Integer, ReadCellData<?>> headMap, AnalysisContext context) {
        ReadListener.super.invokeHead(headMap, context);
    }

    /**
     * 获取每一行的数据信息
     * @param student
     * @param analysisContext
     */
    @Override
    public void invoke(Student student, AnalysisContext analysisContext) {
        studentList.add(student);
        System.out.println("student=="+student);
    }

    /**
     * 写数据完成之后要执行的动作
     * @param analysisContext
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
    public List<Student> getAllDataList(){
        return this.studentList;
    }
}
