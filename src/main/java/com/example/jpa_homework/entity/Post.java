package com.example.jpa_homework.entity;

import com.example.jpa_homework.dto.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
// https://www.daleseo.com/lombok-popular-annotations/
public class Post extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String password;

    public Post(PostRequestDto requestDto) {
//        this.id = requestDto.getId();
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.password = requestDto.getPassword();
    }

    public void update(PostRequestDto requestDto) {
//        this.id = requestDto.getId();
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
//        this.password = requestDto.getPassword();

    }
}
