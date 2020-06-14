package com.example.userweb.controller.api;

import javax.transaction.Transactional;

import com.example.userweb.advice.Exception.CUserNotFoundException;
import com.example.userweb.domain.User;
import com.example.userweb.domain.response.CommonResult;
import com.example.userweb.domain.response.ListResult;
import com.example.userweb.domain.response.SingleResult;
import com.example.userweb.repo.UserRepository;
import com.example.userweb.service.ResponseService;

import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.context.SecurityContextHolder;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = {"1. user"})
@RestController
@RequestMapping(value = "/api")
public class UserController {

    @Autowired
    private UserRepository uRepo;

    @Autowired
    private ResponseService responseService; // 결과를 처리할 Service

    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-AUTH-TOKEN", value = "로그인 성공 후 access_token", required = true, dataType = "String", paramType = "header")
    })
    @ApiOperation(value = "회원 리스트 조회", notes = "모든 회원을 조회한다")
    @GetMapping(value = "/users")
    public ListResult<User> findAllUser() {
        // 결과데이터가 여러건인경우 getListResult를 이용해서 결과를 출력한다.
        return responseService.getListResult(uRepo.findAll());
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-AUTH-TOKEN", value = "로그인 성공 후 access_token", required = false, dataType = "String", paramType = "header")
    })
    @ApiOperation(value = "회원 조회", notes = "회원을 조회한다")
    @GetMapping(value = "/user")
    public SingleResult<User> findUserById(@ApiParam(value = "언어", defaultValue = "ko") @RequestParam String lang) {
        // SecurityContext에서 인증받은 회원의 정보를 얻어온다.
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String id = authentication.getName();
        // 결과데이터가 단일건인경우 getSingleResult를 이용해서 결과를 출력한다.
        return responseService.getSingleResult(uRepo.findByUid(id).orElseThrow(CUserNotFoundException::new));
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-AUTH-TOKEN", value = "로그인 성공 후 access_token", required = true, dataType = "String", paramType = "header")
    })
    @ApiOperation(value = "회원 수정", notes = "회원정보를 수정한다")
    @PutMapping(value = "/user")
    public SingleResult<User> modify(
            @ApiParam(value = "회원 기본키", required = true) @RequestParam Long upk,
            @ApiParam(value = "회원 이름", required = true) @RequestParam String name) {
        User user = User.builder()
                .upk(upk)
                .name(name)
                .build();
        return responseService.getSingleResult(uRepo.save(user));
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-AUTH-TOKEN", value = "로그인 성공 후 access_token", required = true, dataType = "String", paramType = "header")
    })
    @ApiOperation(value = "회원 삭제", notes = "upk로 회원정보를 삭제한다")
    @DeleteMapping(value = "/user/{upk}")
    public CommonResult delete(
            @ApiParam(value = "회원 기본키", required = true) @PathVariable Long upk) {
        uRepo.deleteById(upk);
        // 성공 결과 정보만 필요한경우 getSuccessResult()를 이용하여 결과를 출력한다.
        return responseService.getSuccessResult();
    }
}