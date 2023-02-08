package com.example.jpa_homework.controller;


import com.example.jpa_homework.dto.PostMessageDto;
import com.example.jpa_homework.dto.PostRequestDto;
import com.example.jpa_homework.dto.PostResponseDto;
import com.example.jpa_homework.entity.Post;
import com.example.jpa_homework.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class PostController {
    private final PostService postService;

    //첫 화면
    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("index");
    }

    //게시물 생성
    @PostMapping("/api/post")
    public PostResponseDto createPost (@RequestBody PostRequestDto requestDto) {
        return postService.createPost(requestDto);
    }
    //게시물 전체 조회
    @GetMapping("/api/post")
    public List<Post> getPost() {
        return postService.getPost();
    }

    //선택한 게시물 조회
    @GetMapping("/api/post/{id}")
    public PostResponseDto getPostID(@PathVariable Long id) {
        return postService.getPostID(id);
    }

    //게시물 수정
    @PutMapping("/api/post/{id}")
    public PostResponseDto updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        return postService.updatepost(id, requestDto);
    }

    //게시물 삭제
    @DeleteMapping("api/post/{id}")
    public PostMessageDto deletePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto){
        return postService.deletePost(id, requestDto);
    }
}
