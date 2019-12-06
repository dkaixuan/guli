package com.guli.aliyunoss.util;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.guli.common.constants.ResultCodeEnum;
import com.guli.common.exception.GuliException;

import java.io.InputStream;

/**
 * @author kaixuan
 * @version 1.0
 * @date 2019/11/17 13:30
 */
public class UploadUtil {
    public static void uploadSingleFile(
            String endpoint,
            String accessKeyId,
            String accessKeySecret,
            String fileName,
            String folderName,
            String bucketName,
            InputStream inputStream) {
        try {

            // 创建OSSClient实例。
            OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

            // 存入对象的名称=目录名称+"/"+文件名
            String objectName = folderName + "/" + fileName;

            ossClient.putObject(bucketName, objectName, inputStream);

            // 关闭OSSClient。
            ossClient.shutdown();
        } catch (OSSException e) {
            throw new GuliException(ResultCodeEnum.FILE_UPLOAD_ERROR);
        } catch (ClientException e) {
            throw new GuliException(ResultCodeEnum.UNKNOWN_REASON);
        }
    }
}
