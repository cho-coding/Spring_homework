package com.example.jpa_homework.dto;

import com.example.jpa_homework.entity.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


//https://velog.io/@ohzzi/Entity-DAO-DTO%EA%B0%80-%EB%AC%B4%EC%97%87%EC%9D%B4%EB%A9%B0-%EC%99%9C-%EC%82%AC%EC%9A%A9%ED%95%A0%EA%B9%8C
@Getter
@NoArgsConstructor
public class PostResponseDto {
    private Long id;
    private String username;
    private String contents;
    private String password;
    private LocalDateTime createdAt;
//    private LocalDateTime modifiedAt;

    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.username = post.getUsername();
        this.contents = post.getContents();
        this.password = post.getPassword();
        this.createdAt = post.getCreatedAt();
//        this.modifiedAt = post.getModifiedAt();
    }
}
