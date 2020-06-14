package com.example.userweb.controller;

import javax.transaction.Transactional;

import com.example.userweb.advice.Exception.CUserNotFoundException;
import com.example.userweb.domain.User;
import com.example.userweb.domain.response.CommonResult;
import com.example.userweb.domain.response.ListResult;
import com.example.userweb.domain.response.SingleResult;
import com.example.userweb.repo.UserRepository;
import com.example.userweb.service.ResponseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = {"1. user"})
@RestController
@RequestMapping(value = "/api")
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private ResponseService resService;

    @ApiOperation(value = "멤버 조회", notes = "모든 멤버를 조회한다.")
    @GetMapping(value = "/users")
    public  ListResult<User> allUsers(){
        return resService.getListResult(userRepo.findAll());
    }

    @ApiOperation(value = "멤버 상세 정보", notes = "id로 멤버를 정보를 확인한다.")
    @GetMapping(value = "/user/{id}")
    public SingleResult<User> findUser(@ApiParam(value = "멤버pk", required = true) @PathVariable Long id){
        return resService.getSingleResult(userRepo.findById(id).orElseThrow(CUserNotFoundException::new));
    }

    @ApiOperation(value = "멤버 추가", notes = "멤버를 추가한다.")
    @Transactional
    @PostMapping(value = "/user")
    public CommonResult registerUser(@ApiParam(value = "멤버{id, pw, name}", required = true) @ModelAttribute("user") User user){
        userRepo.save(user);
        return resService.getSuccessResult();
    }

    @ApiOperation(value = "멤버 수정", notes = "멤버를 수정한다.")
    @Transactional
    @PutMapping(value = "/user")
    public CommonResult upadateUser(@ApiParam(value = "멤버{id, pw, name}", required = true) @ModelAttribute("user") User user){
        userRepo.save(user);
        return resService.getSuccessResult();
    }

    @ApiOperation(value = "멤버 삭제", notes = "멤버를 삭제한다.")
    @Transactional
    @DeleteMapping(value = "/user/{id}")
    public CommonResult deleteUser(@ApiParam(value = "멤버pk", required = true) @PathVariable Long id){
        userRepo.deleteById(id);
        return resService.getSuccessResult();
    }
}