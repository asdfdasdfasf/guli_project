package com.atguigu.serviceedu.controller;


import com.atguigu.exception.MyException;
import com.atguigu.result.CommonResult;
import com.atguigu.serviceedu.entity.EduTeacher;
import com.atguigu.serviceedu.entity.vo.TeacherVo;
import com.atguigu.serviceedu.service.EduTeacherService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


import java.util.List;
/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author atguigu
 * @since 2022-05-19
 */
@RestController
@RequestMapping("/serviceedu/edu-teacher")
@CrossOrigin
public class EduTeacherController {

    @Autowired
    private EduTeacherService teacherService;

    /**
     * 获取所有讲师信息
     * @return
     */
    @GetMapping("/getAll")
    public CommonResult getAllTeaher(){
        List<EduTeacher> list = teacherService.list(null);
        return CommonResult.success().data("items",list);
    }

    /**
     * 根据id逻辑删除讲师的信息
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public CommonResult deleteTeacher(@PathVariable("id") String  id){
        boolean result = teacherService.removeById(id);
        return CommonResult.success();
    }

    /**
     * 分页显示教师的信息
     * @param pageNo 当前页数
     * @param limit  展示条数
     * @return
     */
    @GetMapping("/{pageNo}/{limit}")
    public CommonResult teacherPage(@PathVariable("pageNo") Long  pageNo,@PathVariable("limit") Long limit){
        Page<EduTeacher> page=new Page<>(pageNo, limit);
        IPage<EduTeacher> pageInfo = teacherService.page(page, null);
        //获取所有教师信息
        List<EduTeacher> records = pageInfo.getRecords();
        //获取数据库总条数
        long total = pageInfo.getTotal();
        return CommonResult.success().data("items",records).data("total",total);
    }

    /**
     * 条件查询讲师信息
     * @param pageNo 当前页
     * @param limit 每页条数
     * @param teacherVo 查询条件
     * @return
     */
    @PostMapping("/{pageNo}/{limit}")
    public CommonResult teacherPageCondition(@PathVariable("pageNo") Long pageNo,@PathVariable("limit") Long limit,
                                             @RequestBody TeacherVo teacherVo){
        return teacherService.queryTeacherByCondition(pageNo, limit, teacherVo);
    }

    /**
     * 根据id查询讲师信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public CommonResult getTeacherById(@PathVariable("id") Long id){
        EduTeacher teacher = teacherService.getById(id);
        return CommonResult.success().data("item",teacher);
    }

    /**
     * 根据id更新讲师信息
     * @param teacherId
     * @param teacher
     * @return
     */
    @PostMapping("/{id}")
    public CommonResult updateTeacherById(@PathVariable(value = "id",required = false) String teacherId, @RequestBody EduTeacher teacher){
        if(StringUtils.isEmpty(teacher.getId())){
            teacher.setId(teacherId);
        }
        boolean result = teacherService.updateById(teacher);
        return result?CommonResult.success():CommonResult.error();
    }

    /**
     * 添加讲师操作
     * @param eduTeacher
     * @return
     */
    @PostMapping("/save")
    public CommonResult saveTeacher(@RequestBody EduTeacher eduTeacher){
        System.out.println(eduTeacher);
        boolean save = teacherService.save(eduTeacher);

        if(save){
            return CommonResult.success();
        }
        return CommonResult.error();
    }
}

