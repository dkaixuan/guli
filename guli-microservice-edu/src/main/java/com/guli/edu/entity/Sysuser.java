package com.guli.edu.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author kaixuan
 * @version 1.0
 * @date 2019/11/9 14:19
 */
@Data
@TableName("edu_sysuser")
@Accessors(chain = true)
@ApiModel(value ="sysuser对象",description ="后台系统用户")
public class Sysuser implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value ="用户Id")
    @TableId(value ="id",type = IdType.ID_WORKER_STR)
    private String id;
    @ApiModelProperty(value ="系统用户名")
    private String username;
    @ApiModelProperty(value ="系统用户密码")
    private String password;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;




}
