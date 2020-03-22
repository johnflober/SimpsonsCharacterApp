package com.funapps.app.ws.service.impl;

import com.appsdeveloperblog.app.ws.io.entity.UserEntity;
import com.funapps.app.ws.UserRepository;
import com.funapps.app.ws.service.UserService;
import com.funapps.app.ws.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Adds implementation to UserService interface for adding users to database
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository; //Notice how you dont need to create a new instance and has CRUD/DB operations

    @Override
    public UserDto createUser(UserDto user) {

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);

        //Required hard code fields
        userEntity.setEncryptedPassword("test");
        userEntity.setUserId("testUserId");

        UserEntity storedUserDetails = userRepository.save(userEntity);

        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(storedUserDetails, returnValue);

        return null;
    }
}