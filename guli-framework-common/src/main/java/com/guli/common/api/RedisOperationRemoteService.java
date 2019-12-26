package com.guli.common.api;

import com.guli.common.constants.vo.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author kaixuan
 * @version 1.0
 * @date 2019/12/26 16:00
 */
@FeignClient(value = "redis-provider")
public interface RedisOperationRemoteService {

    /**
     * 将字符串类型的键值对保存到Redis时调用的远程方法
     * @param normalKey
     * @param normalValue
     * @param timeoutMinute
     * @return
     */
    R saveNormalStringKeyValue(@RequestParam("normalKey")String normalKey,
                               @RequestParam("normalValue") String normalValue,
                               @RequestParam("timeoutMinute") Integer timeoutMinute);

    /**
     * 根据key查询对应value时调用的远程方法
     * @param normalKey
     * @return
     */
    R retrieveStringValueByStringKey(@RequestParam("normalKey") String normalKey);

    /**
     * 根据key删除对应value时调用的远程方法
     * @param key
     * @return
     */
    @RequestMapping("/redis/remove/by/key")
    R removeByKey(@RequestParam("key") String key);



}
