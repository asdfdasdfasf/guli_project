package com.atguigu.serviceedu.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author KyrieStudy
 * @version 1.0
 * @date 2022/5/22 13:18
 */
@Data
@ApiModel(value="Teacher查询对象",description = "讲师查询条件封装类")
public class TeacherVo {
    @ApiModelProperty(value = "教师名称，模糊查询")
    private String name;

    @ApiModelProperty(value = "教师头衔等级 1 高级讲师 2 首席讲师")
    private Integer level;

    @ApiModelProperty("查询开始时间")
    private String begin;

    @ApiModelProperty("查询结束时间")
    private String end;
}
