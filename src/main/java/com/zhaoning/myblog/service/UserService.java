package com.zhaoning.myblog.service;

import com.zhaoning.myblog.po.User;

/**
 * @author zhaoning
 * @date 2020/5/3 - 19:55
 */
public interface UserService {

    User checkUser(String username,String password);

}
