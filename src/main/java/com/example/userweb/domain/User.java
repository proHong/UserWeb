package com.example.userweb.domain;

import java.sql.Timestamp;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Builder
@Getter
@Setter
@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long upk;

    @Column(nullable = false, unique = true, length = 30)
    @ApiModelProperty(value = "멤버 아이디", required = true)
    private String uid;

    @Column(nullable = false, length = 100)
    @ApiModelProperty(value = "멤버 비밀번호", required = true)
    private String upw;

    @Column(nullable = false, length = 100)
    @ApiModelProperty(value = "멤버 이름", required = true)
    private String uname;

    @CreationTimestamp
    @ApiModelProperty(value = "등록일자", required = false)
    private Timestamp m_regdate;
}