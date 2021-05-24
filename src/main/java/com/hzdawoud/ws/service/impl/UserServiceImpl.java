package com.hzdawoud.ws.service.impl;

import com.hzdawoud.ws.UserRepository;
import com.hzdawoud.ws.entity.UserEntity;
import com.hzdawoud.ws.service.UserService;
import com.hzdawoud.ws.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDto, userEntity);

        userEntity.setEncryptedPassword("test");
        userEntity.setUserId("testUserID");

        UserEntity savedUser = userRepository.save(userEntity);

        UserDto returnedValue = new UserDto();
        BeanUtils.copyProperties(savedUser, returnedValue);

        return returnedValue;
    }
}
