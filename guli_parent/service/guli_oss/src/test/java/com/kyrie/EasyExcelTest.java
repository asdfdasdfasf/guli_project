package com.kyrie;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import jdk.nashorn.internal.runtime.linker.LinkerCallSite;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KyrieStudy
 * @version 1.0
 * @date 2022/6/9 14:21
 */
public class EasyExcelTest {
    /**
     * 测试向excel中写入数据
     */
    @Test
    public void testWrite(){
        String filePath="C:\\Users\\Lenovo\\Desktop\\Student.xlsx";
        EasyExcel.write(filePath,Student.class).sheet().doWrite(EasyExcelTest::getStudentList);
    }

    @Test
    public void testRead(){
        String filePath="C:\\Users\\Lenovo\\Desktop\\Student.xlsx";
        ExcelListener listener=new ExcelListener();
        EasyExcel.read(filePath,Student.class,listener).sheet().doRead();
        for (Student student : listener.getAllDataList()) {
            System.out.println("getAll="+student);
        }

    }
    public static List<Student> getStudentList(){
        List<Student> list =new ArrayList<>();
        for(int i=0;i<10;i++){
            Student student=new Student("kyrie","美国",18);
            list.add(student);
        }
        return list;
    }
}
