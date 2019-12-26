package com.guli.edu.controller.admin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.common.constants.vo.R;
import com.guli.edu.entity.Course;
import com.guli.edu.form.CourseInfoForm;
import com.guli.edu.query.CourseQuery;
import com.guli.edu.service.CourseService;
import com.guli.edu.vo.CoursePublishVo;
import com.guli.edu.vo.CourseTeacherVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author kaixuan
 * @version 1.0
 * @date 2019/12/18 20:14
 */
@Api(description="课程管理")
@CrossOrigin
@RestController
@RequestMapping("/admin/edu/course")
public class CourseAdminController {

    @Autowired
    private CourseService courseService;


    @ApiOperation("新增课程")
    @PostMapping("save-course-info")
    public R saveCourseInfo(
            @ApiParam(name = "CourseInfoForm", value = "课程基本信息", required = true)
            @RequestBody CourseInfoForm courseInfoForm
    ) {
       String courseId=courseService.saveCourseInfo(courseInfoForm);
        return R.ok().data("courseId", courseId);
    }


    @ApiOperation("根据Id查询课程")
    @GetMapping("course-info/{id}")
    public R getById(
            @ApiParam(name="id",value ="课程ID",required =true)
            @PathVariable String id) {

        CourseInfoForm courseInfoForm = courseService.getCourseInfoFormById(id);

        return R.ok().data("item",courseInfoForm);
    }


    @ApiOperation("分页课程列表")
    @GetMapping("{page}/{limit}")
    public R pageQuery(
            @ApiParam(name ="page",value ="当前页码",required = true)
            @PathVariable Long page,

            @ApiParam(name="limit",value ="每页记录数",required =true)
            @PathVariable Long limit,

            @ApiParam(name = "courseQuery", value = "查询对象", required = false)
                    CourseQuery courseQuery
    ){
        Page<CourseTeacherVo> pageParam = new Page<>(page,limit);
        courseService.selectPageVo(pageParam, courseQuery);
        List<CourseTeacherVo> records = pageParam.getRecords();

        long total = pageParam.getTotal();
        return R.ok().data("rows",records).data("total",total);
    }


    @ApiOperation(value = "根据ID删除课程")
    @DeleteMapping("{id}")
    public R removeById(
            @ApiParam(name = "id", value = "课程ID", required = true)
            @PathVariable String id){
        courseService.removeCourseById(id);
        return R.ok();
    }

    @ApiOperation(value ="更新课程")
    @PutMapping("update-course-info/{id}")
    public R updateCourseInfoById(
            @ApiParam(name="CourseInfoFrom",value ="课程基本信息",required = true)
            @RequestBody CourseInfoForm courseInfoForm,

            @ApiParam(name="id",value ="课程ID",required =true)
            @PathVariable String id
    ){
        courseService.updateCourseInfoById(courseInfoForm);

        return R.ok();
    }


    @ApiOperation(value = "根据ID获取课程发布信息")
    @GetMapping("course-publish-info/{id}")
    public R getCoursePublishVoById(
            @ApiParam(name = "id", value = "课程ID", required = true)
            @PathVariable String id){

        CoursePublishVo courseInfoForm = courseService.getCoursePublishVoById(id);
        return R.ok().data("item", courseInfoForm);
    }

    @ApiOperation(value = "根据id发布课程")
    @PutMapping("publish-course/{id}")
    public R publishCourseById(
            @ApiParam(name = "id", value = "课程ID", required = true)
            @PathVariable String id){

        courseService.publishCourseById(id);
        return R.ok();
    }





}
