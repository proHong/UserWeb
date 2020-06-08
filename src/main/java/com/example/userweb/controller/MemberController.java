package com.example.userweb.controller;

import java.util.List;

import javax.transaction.Transactional;

import com.example.userweb.domain.Member;
import com.example.userweb.service.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = {"1. Member"})
@RestController
@RequestMapping(value = "/api")
public class MemberController {

    @Autowired
    private MemberRepository repo;

    @ApiOperation(value = "멤버 조회", notes = "모든 멤버를 조회한다.")
    @GetMapping(value = "/members")
    public  List<Member> allMembers(){
        return repo.findAll();
    }

    @ApiOperation(value = "멤버 상세 정보", notes = "멤버를 정보를 확인한다.")
    @GetMapping(value = "/member/{id}")
    public Member member(@ApiParam(value = "멤버ID", required = true) @PathVariable Long id){
        return repo.findById(id).orElse(null);
    }

    @ApiOperation(value = "멤버 추가", notes = "멤버를 추가한다.")
    @Transactional
    @PostMapping(value = "/member")
    public Member registerMember(@ApiParam(value = "멤버{id, pw, name}", required = true) @ModelAttribute("member") Member member){
        repo.save(member);
        return member;
    }
}