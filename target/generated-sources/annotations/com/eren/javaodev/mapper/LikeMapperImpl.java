package com.eren.javaodev.mapper;

import com.eren.javaodev.dto.LikeDto;
import com.eren.javaodev.dto.PostDto;
import com.eren.javaodev.dto.UserDto;
import com.eren.javaodev.entity.Like;
import com.eren.javaodev.entity.Post;
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
public class LikeMapperImpl implements LikeMapper {

    @Override
    public LikeDto toDto(Like e) {
        if ( e == null ) {
            return null;
        }

        LikeDto likeDto = new LikeDto();

        likeDto.likeId = e.getLikeId();
        likeDto.post = postToPostDto( e.getPost() );
        likeDto.user = userToUserDto( e.getUser() );

        return likeDto;
    }

    @Override
    public Like toEntity(LikeDto r) {
        if ( r == null ) {
            return null;
        }

        Like like = new Like();

        like.setLikeId( r.likeId );
        like.setPost( postDtoToPost( r.post ) );
        like.setUser( userDtoToUser( r.user ) );

        return like;
    }

    @Override
    public List<LikeDto> toDto(List<Like> eList) {
        if ( eList == null ) {
            return null;
        }

        List<LikeDto> list = new ArrayList<LikeDto>( eList.size() );
        for ( Like like : eList ) {
            list.add( toDto( like ) );
        }

        return list;
    }

    @Override
    public List<Like> toEntity(List<LikeDto> rList) {
        if ( rList == null ) {
            return null;
        }

        List<Like> list = new ArrayList<Like>( rList.size() );
        for ( LikeDto likeDto : rList ) {
            list.add( toEntity( likeDto ) );
        }

        return list;
    }

    protected PostDto postToPostDto(Post post) {
        if ( post == null ) {
            return null;
        }

        PostDto postDto = new PostDto();

        postDto.postId = post.getPostId();
        postDto.title = post.getTitle();
        postDto.text = post.getText();

        return postDto;
    }

    protected UserDto userToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.userId = user.getUserId();
        userDto.name = user.getName();
        userDto.surname = user.getSurname();
        userDto.email = user.getEmail();
        userDto.password = user.getPassword();
        userDto.userName = user.getUserName();
        userDto.imgUrl = user.getImgUrl();

        return userDto;
    }

    protected Post postDtoToPost(PostDto postDto) {
        if ( postDto == null ) {
            return null;
        }

        Post post = new Post();

        post.setPostId( postDto.postId );
        post.setTitle( postDto.title );
        post.setText( postDto.text );

        return post;
    }

    protected User userDtoToUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setUserId( userDto.userId );
        user.setName( userDto.name );
        user.setSurname( userDto.surname );
        user.setEmail( userDto.email );
        user.setUserName( userDto.userName );
        user.setPassword( userDto.password );
        user.setImgUrl( userDto.imgUrl );

        return user;
    }
}
