package com.guli.ucenter.controller;

import com.guli.common.constants.vo.R;
import com.guli.ucenter.form.MemberInfoForm;
import com.guli.ucenter.service.MemberService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author kaixuan
 * @version 1.0
 * @date 2019/12/25 20:19
 */
@CrossOrigin
@RequestMapping("/ucenter/member")
@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;



    @ApiOperation(value ="今日注册数")
    @GetMapping(value = "count-register/{day}")
    public R registerCount(
            @ApiParam(name = "day",value = "统计日期")
            @PathVariable String day){

        Integer count = memberService.selectRegisterCount(day);
        return R.ok().data("countRegister",count);
    }


    @PostMapping
    public R login(
            @ApiParam(name="mobile",value = "会员手机号",required =true)
            @RequestBody MemberInfoForm memberForm)
    {


        return R.ok();
    }

}
