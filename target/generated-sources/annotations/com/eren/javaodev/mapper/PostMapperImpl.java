package com.eren.javaodev.mapper;

import com.eren.javaodev.dto.PostDto;
import com.eren.javaodev.entity.Post;
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
public class PostMapperImpl implements PostMapper {

    @Override
    public PostDto toDto(Post e) {
        if ( e == null ) {
            return null;
        }

        PostDto postDto = new PostDto();

        postDto.postId = e.getPostId();
        postDto.title = e.getTitle();
        postDto.text = e.getText();

        return postDto;
    }

    @Override
    public Post toEntity(PostDto r) {
        if ( r == null ) {
            return null;
        }

        Post post = new Post();

        post.setPostId( r.postId );
        post.setTitle( r.title );
        post.setText( r.text );

        return post;
    }

    @Override
    public List<PostDto> toDto(List<Post> eList) {
        if ( eList == null ) {
            return null;
        }

        List<PostDto> list = new ArrayList<PostDto>( eList.size() );
        for ( Post post : eList ) {
            list.add( toDto( post ) );
        }

        return list;
    }

    @Override
    public List<Post> toEntity(List<PostDto> rList) {
        if ( rList == null ) {
            return null;
        }

        List<Post> list = new ArrayList<Post>( rList.size() );
        for ( PostDto postDto : rList ) {
            list.add( toEntity( postDto ) );
        }

        return list;
    }
}
