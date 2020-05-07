package com.zhaoning.myblog.dao;

import com.zhaoning.myblog.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhaoning
 * @date 2020/5/3 - 19:57
 */
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsernameAndPassword(String username,String password);

}
