package com.kyrie;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author KyrieStudy
 * @version 1.0
 * @date 2022/6/9 14:21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student{

    @ExcelProperty(value = "学生姓名",index = 0)
    private String name;

    @ExcelProperty(value = "学生地址",index = 1)
    private String address;

    @ExcelProperty(value = "学生年龄",index = 2)
    private Integer age;

}
