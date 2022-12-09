package com.base.backend.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: base
 * @description: 注册所需的信息
 * @author: zhw
 * @created: 2022/11/16 23:49
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RegisterVo {
    private String username; 
    private String password; 
    private String confirmedPassword;
}

