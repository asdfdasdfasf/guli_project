package com.atguigu.serviceedu.entity.excel;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author KyrieStudy
 * @version 1.0
 * @date 2022/6/9 20:43
 */
@Data
@ApiModel("二级分类")
public class SecondLevel {
    private String id;

    private String title;
}
