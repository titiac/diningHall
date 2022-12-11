package com.base.backend.controller;

import com.base.backend.common.R;
import com.base.backend.pojo.vo.LoginVo;
import com.base.backend.pojo.vo.RechargeVo;
import com.base.backend.pojo.vo.RegisterVo;
import com.base.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * @program: base
 * @description: 用户相关接口
 * @author: zhw
 * @created: 2022/11/16 23:44
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    
    /**
     * @Author: zhw
     * @Description: 注册
     * @DateTime: 2022/12/11 18:45
     */
    @PostMapping("/register")
    public R register(@RequestBody RegisterVo registerVo) {
        return userService.register(registerVo);
    }

    /**
     * @Author: zhw
     * @Description: 登录
     * @DateTime: 2022/12/11 18:45
     */
    @PostMapping("/login")
    public R login(@RequestBody LoginVo loginVo) {
        return userService.login(loginVo);
    }
    
    /**
     * @Author: zhw
     * @Description: 获取用户信息，管理员可以额外获取累计配送量和平均配送时间
     * @DateTime: 2022/12/11 18:45
     */
    @GetMapping("/getInfo")
    public R getInfo() {
        return userService.getInfo();
    }
    
    /**
     * @Author: zhw
     * @Description: 充值
     * @DateTime: 2022/12/11 18:45
     */
    @PostMapping("/recharge")
    public R recharge(@RequestBody RechargeVo rechargeVo){
        return userService.recharge(rechargeVo);
    }
}

