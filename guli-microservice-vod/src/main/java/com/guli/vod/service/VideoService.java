package com.guli.vod.service;

import com.aliyuncs.vod.model.v20170321.CreateUploadVideoResponse;
import com.aliyuncs.vod.model.v20170321.RefreshUploadVideoResponse;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author kaixuan
 * @version 1.0
 * @date 2019/12/18 13:56
 */
public interface VideoService {
    /**
     * 视频上传接口
     * @param file
     * @return
     */
    String uploadVideo(MultipartFile file);

    /**
     * 视频删除接口
     * @param videoId
     */
    void removeVideo(String videoId);

    /**
     * 返回上传地址，上传凭证以及VideoId
     * @param title
     * @param fileName
     * @return
     */
    CreateUploadVideoResponse getUploadAuthAndAddress(String title, String fileName);

    /**
     * 刷新上传凭证
     * @param videoId
     * @return
     */
    RefreshUploadVideoResponse refreshUploadAuthAndAddress(String videoId);


    /**
     * 获取播放凭证
     * @param videoId
     * @return
     */
    String getVideoPlayAuth(String videoId);
}
