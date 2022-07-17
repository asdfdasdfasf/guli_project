package com.atguigu.result;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @author KyrieStudy
 * @version 1.0
 * @date 2022/5/19 17:03
 */
@Data
public class CommonResult {
    @ApiModelProperty(value = "是否成功")
    private Boolean success;

    @ApiModelProperty(value = "响应状态码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private Map<String, Object> data = new HashMap<String, Object>();

    private CommonResult() {

    }

    public static CommonResult success() {
        CommonResult commonResult = new CommonResult();
        commonResult.setSuccess(true);
        commonResult.setCode(20000);
        commonResult.setMessage("响应成功");
        return commonResult;
    }

    public static CommonResult error() {
        CommonResult commonResult = new CommonResult();
        commonResult.setCode(ErrorCode.INNER_ERROR.getCode());
        commonResult.setMessage(ErrorCode.INNER_ERROR.getMsg());
        return commonResult;
    }
    public CommonResult message(String msg,Integer code){
        this.message=msg;
        this.code=code;
        return this;
    }


    public CommonResult data(String key,Object value){
        this.data.put(key,value);
        return this;
    }

}
