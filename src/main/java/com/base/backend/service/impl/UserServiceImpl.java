package com.base.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.base.backend.common.R;
import com.base.backend.common.ResultEnum;
import com.base.backend.mapper.UserMapper;
import com.base.backend.pojo.User;
import com.base.backend.pojo.vo.LoginVo;
import com.base.backend.pojo.vo.RegisterVo;
import com.base.backend.service.UserService;
import com.base.backend.service.impl.utils.UserDetailsImpl;
import com.base.backend.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @program: base
 * @description: 用户相关服务
 * @author: zhw
 * @created: 2022/11/16 23:46
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public R register(RegisterVo registerVo) {
        String username = registerVo.getUsername();
        String password = registerVo.getPassword();
        String confirmedPassword = registerVo.getConfirmedPassword();
        
        if (username == null) {
            return R.error().message("用户名不能为空");
        }
        
        if (password == null || confirmedPassword == null) {
            return R.error().message("密码不能为空");
        }

        username = username.trim();
        if (username.length() == 0) {
            return R.error().message("用户名不能为空");
        }

        if (password.length() == 0 || confirmedPassword.length() == 0) {
            return R.error().message("密码或确认密码不能为空");
        }

        if (username.length() > 100) {
            R.error().message("用户名长度不能超过100");
        }

        if (password.length() > 100 || confirmedPassword.length() > 100) {
            return R.error().message("密码或确认密码长度不能超过100");
        }

        if (!password.equals(confirmedPassword)) {
            return R.error().message("密码与确认密码不同");
        }

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        List<User> users = userMapper.selectList(queryWrapper);
        if (!users.isEmpty()) {
            return R.error().message("用户名已存在");
        }

        String encodedPassword = passwordEncoder.encode(password);
        User user = new User(null, username, encodedPassword, 0.0, 1);
        userMapper.insert(user);
        return R.ok();
    }

    @Override
    public R login(LoginVo loginVo) {
        String username = loginVo.getUsername();
        String password = loginVo.getPassword();

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(username, password);

        Authentication authenticate = authenticationManager.authenticate(authenticationToken);  // 登录失败，会自动处理
        UserDetailsImpl loginUser = (UserDetailsImpl) authenticate.getPrincipal();
        User user = loginUser.getUser();
        String jwt = JwtUtil.createJWT(user.getId().toString());

        Map<String, Object> loginReturn = new HashMap<>();
        loginReturn.put("token", jwt);
        loginReturn.put("user", user);
        
        return R.ok().data(loginReturn);
    }

    @Override
    public R getInfo() {
        UsernamePasswordAuthenticationToken authentication =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        UserDetailsImpl loginUser = (UserDetailsImpl) authentication.getPrincipal();
        User user = loginUser.getUser();
        return R.ok().data("myselfInfo", user);
    }
}

