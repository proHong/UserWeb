package com.example.userweb.service;

import com.example.userweb.advice.Exception.CUserNotFoundException;
import com.example.userweb.repo.UserRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CUserDetailService implements UserDetailsService{
    private final UserRepository uRepo;

    public UserDetails loadUserByUsername(String userPk) {
        return uRepo.findById(Long.valueOf(userPk)).orElseThrow(CUserNotFoundException::new);
    }
}