package com.atguigu.serviceedu.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author KyrieStudy
 * @version 1.0
 * @date 2022/6/9 15:40
 */
@Data
public class ExcelSubject {
    @ExcelProperty(index = 0)
    private String firstLevelSubject;

    @ExcelProperty(index = 1)
    private String secondLevelSubject;
}
