package com.hzdawoud.ws.ui.controller;

import com.hzdawoud.ws.service.UserService;
import com.hzdawoud.ws.dto.UserDto;
import com.hzdawoud.ws.ui.model.request.UserRequestModel;
import com.hzdawoud.ws.ui.model.response.UserRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public String getUser() {
        return "get user called";
    }

    @PostMapping
    public UserRest postUser(@RequestBody UserRequestModel user) {
        UserRest returnedValue = new UserRest();

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);

        UserDto createdUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createdUser, returnedValue);

        return returnedValue;
    }

    @PutMapping
    public String updateUser() {
        return "update user called";
    }

    @DeleteMapping
    public String deleteUser() {
        return "delete user called";
    }
}
