package com.guli.edu.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kaixuan
 * @version 1.0
 * @date 2019/12/20 20:22
 */
@ApiModel(value ="章节信息")
@Data
public class ChapterVo {
    private static final long serialVersionUID = 1L;

    private String id;
    private String title;
    private List<VideoVo> children = new ArrayList<>();
}
