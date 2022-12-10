package com.base.backend.service;

import com.base.backend.common.R;
import com.base.backend.pojo.vo.LoginVo;
import com.base.backend.pojo.vo.RechargeVo;
import com.base.backend.pojo.vo.RegisterVo;

import java.util.Map;


public interface UserService {
    R register(RegisterVo registerVo);

    R login(LoginVo loginVo);

    R getInfo();

    R recharge(RechargeVo rechargeVo);
}
