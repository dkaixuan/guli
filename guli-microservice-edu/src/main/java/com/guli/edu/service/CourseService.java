package com.guli.edu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.edu.entity.Course;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guli.edu.form.CourseInfoForm;
import com.guli.edu.query.CourseQuery;
import com.guli.edu.vo.CoursePublishVo;
import com.guli.edu.vo.CourseTeacherVo;
import com.guli.edu.vo.CourseWebVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author kaixuan
 * @since 2019-11-04
 */
public interface CourseService extends IService<Course> {

    /**
     * 保存课程和课程详情信息
     * @param courseInfoForm
     * @return 新生成的课程Id
     */
    String saveCourseInfo(CourseInfoForm courseInfoForm);

    /**
     * 课程信息回显
     * @param id
     * @return 课程Id
     */
    CourseInfoForm getCourseInfoFormById(String id);


    /**
     * 课程列表
     * @param pageParam
     * @param courseQuery 课程搜索对象
     */
    IPage<CourseTeacherVo> selectPageVo(Page<CourseTeacherVo> pageParam,@Param("courseQuery")CourseQuery courseQuery);

    void removeCourseById(String id);

    /**
     * 课程信息修改
     * @param courseInfoForm
     */
    void updateCourseInfoById(CourseInfoForm courseInfoForm);

    /**
     * 根据id查询课程发布信息
     * @param id
     * @return
     */
    CoursePublishVo getCoursePublishVoById(String id);


    /**
     * 根据Id 发布课程
     * @param id
     */
    void publishCourseById(String id);

    /**
     * 根据TeacherId 查询讲师所讲课程
     * @param teacherId
     * @return
     */
    List<Course> selectByTeacherId(String teacherId);


    /**
     * 前台课程分页列表
     * @param pageParam
     * @return
     */
    Map<String, Object> pageListWeb(Page<Course> pageParam);

    /**
     * 获取课程信息
     * @param id
     * @return
     */
    CourseWebVo selectCourseWebVoById(String id);

}

