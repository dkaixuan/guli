package com.guli.edu.controller.admin;

import com.guli.common.constants.vo.R;
import com.guli.edu.entity.Sysuser;
import com.guli.edu.service.SysuserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author kaixuan
 * @version 1.0
 * @date 2019/11/9 14:15
 */
@Api(description ="用户信息管理")
@RestController
@RequestMapping("/admin/sysuser")
@CrossOrigin
public class SysUserController {

    @Autowired
    SysuserService sysuserService;


    @PostMapping("login")
    @ApiOperation("用户登录")
    public R login(
            @ApiParam(name ="sysuser",value ="系统对象",required =true)
            @RequestBody Sysuser sysuser) {


        return R.ok().data("token","admin");
    }

    @GetMapping("info")
    @ApiOperation(value = "获取用户信息")
    public R info(
            @ApiParam(name = "token", value = "令牌", required = true)
            @RequestParam String token){

        return R.ok()
                .data("roles", "admin")
                .data("name", "admin")
                .data("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }

    @PostMapping("logout")
    @ApiOperation(value = "用户登出")
    public R logout(){
        return R.ok();
    }







}
