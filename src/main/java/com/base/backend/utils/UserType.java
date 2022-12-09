package com.base.backend.utils;

import com.base.backend.pojo.User;
import com.base.backend.service.impl.utils.UserDetailsImpl;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @program: diningHall
 * @description: 返回访问用户类别
 * @author: zhw
 * @created: 2022/12/09 16:10
 */
public class UserType {
    public static Integer getUserType() {
        UsernamePasswordAuthenticationToken authentication =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        UserDetailsImpl loginUser = (UserDetailsImpl) authentication.getPrincipal();
        User user = loginUser.getUser();
        return user.getType();
    }
}

