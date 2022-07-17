package com.atguigu.serviceedu.entity.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import java.util.List;
/**
 * @author KyrieStudy
 * @version 1.0
 * @date 2022/6/13 16:31
 * 章节类
 */
@Data
@ApiModel("章节")
public class ChapterVo {
    private String id;

    private String title;

    private List<VideoVo> videoVoList;
}
