package com.eren.javaodev.mapper;

import com.eren.javaodev.dto.CommentDto;
import com.eren.javaodev.entity.Comment;
import org.mapstruct.Mapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.salesforce.atrium")
@Mapper(componentModel = "spring")
public interface CommentMapper extends IEntityMapper<CommentDto, Comment>{


}
