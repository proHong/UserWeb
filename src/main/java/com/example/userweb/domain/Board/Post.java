package com.example.userweb.domain.Board;

import javax.persistence.*;

import com.example.userweb.domain.User;
import com.example.userweb.domain.Board.Board;
import com.example.userweb.domain.common.CommonDateEntity;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Entity
@Table(name = "post")
@NoArgsConstructor
public class Post extends CommonDateEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;

    @Column(nullable = false, length = 100)
    @ApiModelProperty(value = "제목", required = true)
    private String title;

    @Column(nullable = false, length = 50)
    @ApiModelProperty(value = "작성자", required = true)
    private String writer;

    @Column(length = 500)
    @ApiModelProperty(value = "내용")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bid")
    private Board board;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "upk")
    private User user;

    // 생성자
    public Post(User user, Board board, String writer, String title, String content) {
        this.user = user;
        this.board = board;
        this.writer = writer;
        this.title = title;
        this.content = content;
    }
    // 수정시 데이터 처리
    public Post setUpdate(String writer, String title, String content) {
        this.writer = writer;
        this.title = title;
        this.content = content;
        return this;
    }
}