package com.atguigu.serviceedu.service.impl;

import com.atguigu.result.CommonResult;
import com.atguigu.serviceedu.entity.EduTeacher;
import com.atguigu.serviceedu.entity.vo.TeacherVo;
import com.atguigu.serviceedu.service.EduTeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.atguigu.serviceedu.service.impl.EduTeacherServiceImpl;
import com.atguigu.serviceedu.mapper.EduTeacherMapper;
import org.springframework.util.StringUtils;

import javax.el.BeanNameELResolver;
import java.util.List;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author atguigu
 * @since 2022-05-19
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {
    /**
     * 通过条件分页查询讲师数据
     * @param pageNo 当前页数
     * @param limit 每页条数
     * @param teacherVo 查询条件
     * @return
     */
    @Override
    public CommonResult queryTeacherByCondition(Long pageNo, Long limit, TeacherVo teacherVo) {
        String name = teacherVo.getName();
        String begin = teacherVo.getBegin();
        String end = teacherVo.getEnd();
        Integer level = teacherVo.getLevel();
        Page<EduTeacher> page=new Page<>(pageNo,limit);
        QueryWrapper<EduTeacher> wrapper=new QueryWrapper();
        //判断条件判空和空字符串操作
        if(!StringUtils.isEmpty(name)){
            wrapper.like("name",name);
        }
        if(!StringUtils.isEmpty(level)){
            wrapper.eq("level",level);
        }
        if(!StringUtils.isEmpty(begin)){
            wrapper.ge("gmt_create",begin);
        }
        if(!StringUtils.isEmpty(begin)){
            wrapper.le("gmt_end",end);
        }
        //按照修改时间进行排序
        wrapper.orderByDesc("gmt_modified");
        //调用自带的page方法
        IPage<EduTeacher> pageInfo = this.page(page, wrapper);
        //获取数据
        List<EduTeacher> records = pageInfo.getRecords();
        //获取当前查询结果的总条数
        long total = pageInfo.getTotal();
        return CommonResult.success().data("items",records).data("total",total);
    }
}
