package com.eren.javaodev.mapper;

import com.eren.javaodev.dto.LikeDto;
import com.eren.javaodev.entity.Like;
import org.mapstruct.Mapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.salesforce.atrium")
@Mapper(componentModel = "spring")
public interface LikeMapper extends IEntityMapper<LikeDto, Like>{

}
