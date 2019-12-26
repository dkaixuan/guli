package com.guli.edu.service;

import com.guli.edu.entity.Chapter;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guli.edu.vo.ChapterVo;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author kaixuan
 * @since 2019-11-04
 */
public interface ChapterService extends IService<Chapter> {

    /**
     * 根据ID 删除章节 和章节视频
     * @param id
     */
    void removeChapterById(String id);

    List<ChapterVo> nestedList(String courseId);
}
