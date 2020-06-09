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
    @Column(nullable = false, unique = true, length = 30)
    @ApiModelProperty(value = "멤버 아이디", required = true)
    private String m_id;

    @Column(nullable = false, length = 100)
    @ApiModelProperty(value = "멤버 비밀번호", required = true)
    private String m_pw;

    @Column(nullable = false, length = 100)
    @ApiModelProperty(value = "멤버 이름", required = true)
    private String m_name;

    @CreationTimestamp
    @ApiModelProperty(value = "등록일자", required = false)
    private Timestamp m_regdate;
}