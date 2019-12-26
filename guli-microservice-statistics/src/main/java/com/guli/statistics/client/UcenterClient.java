package com.guli.statistics.client;

import com.guli.common.constants.vo.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author kaixuan
 * @version 1.0
 * @date 2019/12/22 13:48
 */
@Component
@FeignClient("guli-ucenter")
public interface UcenterClient {
    /**
     * 注意：一定要写成 @PathVariable("day")，圆括号中的"day"不能少
     * @param day
     * @return
     */
    @GetMapping(value = "/admin/ucenter/member/count-register/{day}")
    R registerCount(@PathVariable("day") String day);


}
