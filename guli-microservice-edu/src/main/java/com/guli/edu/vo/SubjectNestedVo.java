package com.guli.edu.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kaixuan
 * @version 1.0
 * @date 2019/12/5 11:32
 */
@Data
public class SubjectNestedVo {
    private String id;
    private String title;
    private List<SubjectVo> children = new ArrayList<>();
}
