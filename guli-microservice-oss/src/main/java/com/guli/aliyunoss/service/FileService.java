package com.guli.aliyunoss.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author kaixuan
 * @version 1.0
 * @date 2019/11/15 20:39
 */
public interface FileService {
    /**
     * 文件上传至阿里云
     * @param file
     * @return
     */
    String upload(MultipartFile file) throws IOException;
}
