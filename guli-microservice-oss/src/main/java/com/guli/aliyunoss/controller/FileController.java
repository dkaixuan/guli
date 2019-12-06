package com.guli.aliyunoss.controller;

import com.guli.aliyunoss.service.FileService;
import com.guli.common.constants.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.security.krb5.internal.crypto.Des;

import java.io.IOException;

/**
 * @author kaixuan
 * @version 1.0
 * @date 2019/11/17 15:18
 */
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
        @RequestParam("file")MultipartFile multipartFile) throws IOException {

        String uploadUrl = fileService.upload(multipartFile);
        return R.ok().data("url", uploadUrl);

    }


}
