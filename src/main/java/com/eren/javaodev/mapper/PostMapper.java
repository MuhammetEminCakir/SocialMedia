package com.eren.javaodev.mapper;

import com.eren.javaodev.dto.PostDto;
import com.eren.javaodev.entity.Post;
import org.mapstruct.Mapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.salesforce.atrium")
@Mapper(componentModel = "spring")
public interface PostMapper extends IEntityMapper<PostDto, Post>{

}
