package com.example.jpa_homework.dto;


import com.example.jpa_homework.entity.Post;
import lombok.Builder;
import lombok.Getter;

//데이터를 담는 그릇
//외부 시스템과 데이터 통신을 하기 위함
@Getter
public class PostRequestDto {
    private Long id;
    private String username;
    private String contents;
    private String password;

}


