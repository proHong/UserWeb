package com.example.userweb.repo.Board;

import java.util.List;

import com.example.userweb.domain.Board.Board;
import com.example.userweb.domain.Board.Post;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByBoard(Board board);
}