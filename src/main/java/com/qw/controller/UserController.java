package com.qw.controller;

import com.qw.entity.User;
import com.qw.utils.JwtUtils;
import com.qw.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Api(value = "用户接口",tags={"用户接口"})
public class UserController {
    @PostMapping("/login")
    @ApiOperation("用户登录")
    public Result login(@RequestBody User user){
        String token = JwtUtils.generateToken(user.getUsername());
        return Result.ok().data("token",token);
    }
}
