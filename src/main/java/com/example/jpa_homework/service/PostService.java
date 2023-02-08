package com.example.jpa_homework.service;

import com.example.jpa_homework.dto.PostMessageDto;
import com.example.jpa_homework.dto.PostRequestDto;
import com.example.jpa_homework.dto.PostResponseDto;
import com.example.jpa_homework.entity.Post;
import com.example.jpa_homework.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    //게시글 생성
    @Transactional
    public PostResponseDto createPost(PostRequestDto requestDto) {
        Post post = new Post(requestDto);
        //post에서 여기랑 연결 (PostRequestDto requestDto)
        postRepository.save(post);
        PostResponseDto postResponseDto = new PostResponseDto(post);
        return postResponseDto;
    }

    //게시글 전체 조회
    //https://melonicedlatte.com/2022/02/19/124300.html
    @Transactional
    public List<Post> getPost() {
        return postRepository.findAllByOrderByModifiedAtDesc();
    }

    //선택한 게시글 조회
    @Transactional(readOnly = true)
    public PostResponseDto getPostID(Long id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 없습니다." + id));
        PostResponseDto postResponseDto = new PostResponseDto(post);
        return postResponseDto;
    }

    //게시글 수정하기
    @Transactional(readOnly = true)
    public PostResponseDto updatepost(Long id, PostRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );

        if (requestDto.getPassword().equals(post.getPassword())) {
            post.update(requestDto);
        }
//        this.postRepository.save(post);
        PostResponseDto postResponseDto = new PostResponseDto(post);
        return postResponseDto;
    }

    //게시글 삭제
    @Transactional
    public PostMessageDto deletePost(Long id, PostRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );

        PostMessageDto postMessageDto = new PostMessageDto();
        if (requestDto.getPassword().equals(post.getPassword())) {
            postRepository.deleteById(id);
            postMessageDto.postMessage("삭제완료!");
            return postMessageDto;
        } else {
            postMessageDto.postMessage("삭제실패!");
        }
        return postMessageDto;
    }
}