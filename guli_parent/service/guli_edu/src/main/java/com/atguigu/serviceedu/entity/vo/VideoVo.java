package com.atguigu.serviceedu.entity.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author KyrieStudy
 * @version 1.0
 * @date 2022/6/13 16:32
 */
@Data
@ApiModel("每章小结")
public class VideoVo {
    private String id;

    private String title;
}
