package com.example.userweb.domain.Board;

import javax.persistence.*;

import com.example.userweb.domain.common.CommonDateEntity;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Entity
@Table(name = "board")
@NoArgsConstructor
public class Board extends CommonDateEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bid;

    @Column(nullable = false, length = 100)
    @ApiModelProperty(value = "게시판 이름", required = true)
    private String name;
}