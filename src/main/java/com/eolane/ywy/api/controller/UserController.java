package com.eolane.ywy.api.controller;

import com.eolane.ywy.api.dto.ResultDTO;
import com.eolane.ywy.api.service.IUserService;
import com.eolane.ywy.api.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/users")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "")
    public ResultDTO listUser() {
        return ResultUtil.success(userService.listUser());
    }
}
