package com.guli.aliyunoss.service.impl;

import com.guli.aliyunoss.service.FileService;
import com.guli.aliyunoss.util.ConstantPropertiesUtil;
import com.guli.aliyunoss.util.UploadUtil;
import com.guli.common.util.GuliUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author kaixuan
 * @version 1.0
 * @date 2019/11/15 20:40
 */
@Service
public class FileServiceImpl implements FileService {

    @Override
    public String upload(MultipartFile file) throws IOException {
        //获取阿里云存储相关常量
        String endPoint = ConstantPropertiesUtil.END_POINT;
        String accessKeyId = ConstantPropertiesUtil.ACCESS_KEY_ID;
        String accessKeySecret = ConstantPropertiesUtil.ACCESS_KEY_SECRET;
        String bucketName = ConstantPropertiesUtil.BUCKET_NAME;


        InputStream inputStream = file.getInputStream();
        String originalFilename = file.getOriginalFilename();
        String fileName = GuliUtils.generateFileName(originalFilename);

        String ossProjectParentFolder = "project";
        String forderName = GuliUtils.generateForderNamebyData(ossProjectParentFolder);

        UploadUtil.uploadSingleFile(endPoint, accessKeyId, accessKeySecret,fileName, forderName, bucketName, inputStream);

        String uploadUrl = "http://" + bucketName + "." + endPoint + "/"+forderName+"/"+fileName;

        return uploadUrl;
    }
}
