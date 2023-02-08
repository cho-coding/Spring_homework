package com.example.jpa_homework.repository;

import com.example.jpa_homework.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByOrderByModifiedAtDesc();


//    List<Post> findAllBy(Long id);
}
