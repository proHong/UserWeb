package com.example.userweb.domain;

import java.sql.Timestamp;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "Members")
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "멤버 넘버", hidden = true)
    private Long m_no;

    @Column(nullable = false, unique = true, length = 30)
    @ApiModelProperty(value = "멤버 아이디", required = true)
    private String id;

    @Column(nullable = false, length = 100)
    @ApiModelProperty(value = "멤버 비밀번호", required = true)
    private String pw;

    @Column(nullable = false, length = 100)
    @ApiModelProperty(value = "멤버 이름", required = true)
    private String name;

    @CreationTimestamp
    @ApiModelProperty(value = "등록일자", required = false)
    private Timestamp regdate;
}