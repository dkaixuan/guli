package com.guli.edu.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author kaixuan
 * @version 1.0
 * @date 2019/12/20 22:53
 */
@ApiModel(value = "课程发布信息")
@Data
public class CoursePublishVo {
    private static final long serialVersionUID = 1L;

    private String title;
    private String cover;
    private Integer lessonNum;
    private String subjectLevelOne;
    private String subjectLevelTwo;
    private String teacherName;
    /**
     *  只用于显示
     */
    private String price;
}
