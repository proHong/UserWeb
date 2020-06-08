package com.example.userweb.controller;

import java.util.List;

import javax.transaction.Transactional;

import com.example.userweb.domain.Member;
import com.example.userweb.service.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class ApiController {

    @Autowired
    private MemberRepository repo;

    @GetMapping(value = "/members")
    public  List<Member> allMembers(){
        return repo.findAll();
    }

    @Transactional
    @PostMapping(value = "/members")
    public Member registerMember(@ModelAttribute("member") Member member){
        repo.save(member);
        return member;
    }
}