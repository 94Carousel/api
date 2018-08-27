package com.eolane.ywy.api.service.impl;

import com.eolane.ywy.api.entity.User;
import com.eolane.ywy.api.repository.UserRepository;
import com.eolane.ywy.api.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> listUser() {
        return userRepository.findAll();
    }
}
