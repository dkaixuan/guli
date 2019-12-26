package com.guli.aliyunoss.controller;

import com.guli.aliyunoss.service.FileService;
import com.guli.aliyunoss.util.ConstantPropertiesUtil;
import com.guli.common.constants.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author kaixuan
 * @version 1.0
 * @date 2019/11/17 15:18
 */
@Api(description ="阿里云oss文件上传")
@CrossOrigin
@RestController
@RequestMapping("/admin/oss/file")
public class FileController {


    @Autowired
    private FileService fileService;


    /**
     * 文件上传
     * @param multipartFile
     * @return
     * @throws IOException
     */
    @ApiOperation(value ="文件上传")
    @PostMapping("upload")
    public R upload(
        @ApiParam(name = "file",value ="文件",required = true)
        @RequestParam("file")MultipartFile multipartFile,
        @ApiParam(name="host",value ="文件上传路径",required = false)
        @RequestParam(value = "host",required = false) String host

    ) throws IOException {
        if(!StringUtils.isEmpty(host)){
            ConstantPropertiesUtil.FILE_HOST = host;
        }
        String uploadUrl = fileService.upload(multipartFile);
        return R.ok().data("url", uploadUrl);

    }


}
