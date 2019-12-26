package com.guli.edu.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.edu.entity.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guli.edu.query.CourseQuery;
import com.guli.edu.vo.CoursePublishVo;
import com.guli.edu.vo.CourseTeacherVo;
import com.guli.edu.vo.CourseWebVo;
import org.apache.ibatis.annotations.Param;


/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author kaixuan
 * @since 2019-11-04
 */
public interface CourseMapper extends BaseMapper<Course> {

    IPage<CourseTeacherVo> selectPageVo(Page page, @Param("courseQuery") CourseQuery courseQuery);

    CoursePublishVo selectCoursePublishVoById(String id);

    CourseWebVo selectCourseWebVoById(String courseId);
}
