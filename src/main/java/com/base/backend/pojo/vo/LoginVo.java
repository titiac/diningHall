package com.base.backend.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: base
 * @description: 用户登录所需的对象
 * @author: zhw
 * @created: 2022/11/16 23:58
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginVo {
    private String username;
    private String password;
}

