package com.example.userweb.repo.Board;

import com.example.userweb.domain.Board.Board;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Board findByName(String name);
}