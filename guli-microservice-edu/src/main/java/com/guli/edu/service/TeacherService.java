package com.guli.edu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.edu.entity.Course;
import com.guli.edu.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guli.edu.query.TeacherQuery;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author kaixuan
 * @since 2019-11-04
 */
public interface TeacherService extends IService<Teacher> {

    /**
     * 后台讲师分页列表
     * @param pageParam
     * @param teacherQuery
     */
    void pageQuery(Page<Teacher> pageParam, TeacherQuery teacherQuery);

    /**
     * 前台讲师分页列表
     * @param pageParam
     * @return
     */
    Map<String, Object> pageListWeb(Page<Teacher> pageParam);


}
