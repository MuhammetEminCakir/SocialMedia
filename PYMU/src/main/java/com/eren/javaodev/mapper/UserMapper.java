package com.eren.javaodev.mapper;

import com.eren.javaodev.dto.UserDto;
import com.eren.javaodev.entity.User;
import org.mapstruct.Mapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.salesforce.atrium")
@Mapper(componentModel = "spring")
public interface UserMapper extends IEntityMapper<UserDto, User>{

}
