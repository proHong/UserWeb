package com.example.userweb.domain;

import java.sql.Timestamp;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

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
    private Long m_no;

    @Column(nullable = false, unique = true, length = 30)
    private String id;

    @Column(nullable = false, length = 100)
    private String pw;

    @Column(nullable = false, length = 100)
    private String name;

    @CreationTimestamp
    private Timestamp regdate;
}