package com.login.form.service;

import com.login.form.entity.User;
import com.login.form.repository.RoleRepository;
import com.login.form.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;

@Component
public class UserServiceImpl implements UserService{

    UserRepository userRepository;
    RoleRepository roleRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository){
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public User findUserByEmail(String email) {
        return this.findUserByEmail(email);
    }

    @Override
    public User findUserByUserName(String userName) {
        return this.findUserByUserName(userName);
    }

    @Override
    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.set_active(true);
        user.setRoles(new HashSet<>(Arrays.asList(roleRepository.findByRole("ADMIN"))));
        return this.userRepository.save(user);

    }
}
