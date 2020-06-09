package com.example.userweb.service;

import java.util.List;

import com.example.userweb.domain.Member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member,String>{

    @Modifying
    @Query(value = "update Member m set m.m_pw = :#{#member.m_pw} where m.m_id = :#{#member.m_id}")
    Integer updatePw(@Param("member") Member member);

    @Modifying
    @Query(value = "update Member m set m.m_name = :#{#member.m_name} where m.m_id = :#{#member.m_id}")
    Integer updateName(@Param("member") Member member);
}