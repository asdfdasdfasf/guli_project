package com.atguigu.serviceedu.entity.vo;

import com.atguigu.serviceedu.entity.excel.SecondLevel;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;
/**
 * @author KyrieStudy
 * @version 1.0
 * @date 2022/6/9 20:43
 */
@Data
@ApiModel("返回课程列表对象")
public class SubjectVo {
    private String id;

    private String title;

    private List<SecondLevel> children;
}
