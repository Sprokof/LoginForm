package com.login.form.service;

import com.login.form.entity.User;
import org.springframework.stereotype.Component;

@Component
public interface UserService {
    User findUserByEmail(String email);
    User findUserByUserName(String userName);
    User saveUser(User user);
}
