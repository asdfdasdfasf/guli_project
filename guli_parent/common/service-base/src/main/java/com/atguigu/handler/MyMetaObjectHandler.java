package com.atguigu.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author KyrieStudy
 * @version 1.0
 * @date 2022/5/22 14:13
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        //在讲师被添加的时候自动填充创建和修改时间，字段名和类的字段名相同
        this.setFieldValByName("gmtCreate", new Date(), metaObject);
        this.setFieldValByName("gmtModified", new Date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        //在讲师被更新的时候自动更新时间
        this.setFieldValByName("gmtModified", new Date(), metaObject);

    }
}