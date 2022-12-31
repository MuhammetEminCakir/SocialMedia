package com.eren.javaodev.mapper;

import com.eren.javaodev.dto.CommentDto;
import com.eren.javaodev.dto.PostDto;
import com.eren.javaodev.dto.UserDto;
import com.eren.javaodev.entity.Comment;
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
public class CommentMapperImpl implements CommentMapper {

    @Override
    public CommentDto toDto(Comment e) {
        if ( e == null ) {
            return null;
        }

        CommentDto commentDto = new CommentDto();

        commentDto.commentId = e.getCommentId();
        commentDto.text = e.getText();
        commentDto.post = postToPostDto( e.getPost() );
        commentDto.user = userToUserDto( e.getUser() );

        return commentDto;
    }

    @Override
    public Comment toEntity(CommentDto r) {
        if ( r == null ) {
            return null;
        }

        Comment comment = new Comment();

        comment.setCommentId( r.commentId );
        comment.setText( r.text );
        comment.setPost( postDtoToPost( r.post ) );
        comment.setUser( userDtoToUser( r.user ) );

        return comment;
    }

    @Override
    public List<CommentDto> toDto(List<Comment> eList) {
        if ( eList == null ) {
            return null;
        }

        List<CommentDto> list = new ArrayList<CommentDto>( eList.size() );
        for ( Comment comment : eList ) {
            list.add( toDto( comment ) );
        }

        return list;
    }

    @Override
    public List<Comment> toEntity(List<CommentDto> rList) {
        if ( rList == null ) {
            return null;
        }

        List<Comment> list = new ArrayList<Comment>( rList.size() );
        for ( CommentDto commentDto : rList ) {
            list.add( toEntity( commentDto ) );
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
