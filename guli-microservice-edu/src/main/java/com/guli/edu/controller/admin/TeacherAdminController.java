package com.guli.edu.controller.admin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.common.constants.vo.R;
import com.guli.edu.entity.Teacher;
import com.guli.edu.query.TeacherQuery;
import com.guli.edu.service.TeacherService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author kaixuan
 * @version 1.0
 * @date 2019/11/4 14:53
 */
@RestController
@RequestMapping("/admin/edu/teacher")
public class TeacherAdminController {


    @Autowired
    private TeacherService teacherService;

    @ApiOperation("所有讲师列表")
    @GetMapping
    public R list() {
        List<Teacher> list = teacherService.list(null);
        return R.ok().data("item", list).message("查询成功");
    }

    @ApiOperation("根据id删除讲师")
    @DeleteMapping("{id}")
    public R removeById(
            @ApiParam(name ="id",value ="讲师Id",required =true)
            @PathVariable String id) {
        teacherService.removeById(id);
        return R.ok().message("删除成功");
    }

    @ApiOperation("分页教师列表")
    @GetMapping("{page}/{limit}")
    public R pageList(@ApiParam(name ="page",value ="当前页码",required =true)
                      @PathVariable Long page,
                      @ApiParam(name ="limit",value ="每页显示数",required =true)
                      @PathVariable Long limit,
                      @ApiParam(name="teacherQuery",value ="讲师查询对象",required =false)
                      TeacherQuery teacherQuery) {
        Page<Teacher> pageParam = new Page<>(page, limit);
        teacherService.pageQuery(pageParam, teacherQuery);
        List<Teacher> records = pageParam.getRecords();
        long total = pageParam.getTotal();

        return R.ok().data("total",total).data("rows",records);
    }















}
