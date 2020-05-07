package com.zhaoning.myblog.service;

import com.zhaoning.myblog.dao.UserRepository;
import com.zhaoning.myblog.po.User;
import com.zhaoning.myblog.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhaoning
 * @date 2020/5/3 - 19:56
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User checkUser(String username, String password) {

        User user = userRepository.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }
}
