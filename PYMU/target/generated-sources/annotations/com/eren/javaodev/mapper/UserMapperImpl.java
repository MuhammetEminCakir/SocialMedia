package com.eren.javaodev.mapper;

import com.eren.javaodev.dto.UserDto;
import com.eren.javaodev.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-15T21:23:29+0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 18.0.1.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toDto(User e) {
        if ( e == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.userId = e.getUserId();
        userDto.name = e.getName();
        userDto.surname = e.getSurname();
        userDto.email = e.getEmail();
        userDto.password = e.getPassword();
        userDto.userName = e.getUserName();
        userDto.imgUrl = e.getImgUrl();

        return userDto;
    }

    @Override
    public User toEntity(UserDto r) {
        if ( r == null ) {
            return null;
        }

        User user = new User();

        user.setUserId( r.userId );
        user.setName( r.name );
        user.setSurname( r.surname );
        user.setEmail( r.email );
        user.setUserName( r.userName );
        user.setPassword( r.password );
        user.setImgUrl( r.imgUrl );

        return user;
    }

    @Override
    public List<UserDto> toDto(List<User> eList) {
        if ( eList == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( eList.size() );
        for ( User user : eList ) {
            list.add( toDto( user ) );
        }

        return list;
    }

    @Override
    public List<User> toEntity(List<UserDto> rList) {
        if ( rList == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( rList.size() );
        for ( UserDto userDto : rList ) {
            list.add( toEntity( userDto ) );
        }

        return list;
    }
}
