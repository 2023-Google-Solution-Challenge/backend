package com.example.signz.controller;

import com.example.signz.dto.ResponseDto;
import com.example.signz.entity.Member;
import com.example.signz.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {
    @Autowired
    private MemberService memberService;

    @PostMapping("/users/login")
    public @ResponseBody ResponseDto<?> login(@RequestBody Member member, HttpSession session) {
        Member findMember = memberService.getMember(member.getEmail());

        // 검색 결과 유무와 사용자가 입력한 비밀번호가 유효한지 확인
        if (findMember.getEmail() == null) {
            return new ResponseDto<>(HttpStatus.BAD_REQUEST.value(), "아이디가 존재하지 않습니다.");
        } else {
            if (member.getPassword().equals(findMember.getPassword())) {
                // 로그인 성공 시 세션에 사용자 정보 저장
                session.setAttribute("principal", findMember);
                return new ResponseDto<>(HttpStatus.OK.value(),
                        findMember.getEmail() + "님 로그인 성공하셨습니다.");
            } else {
                return new ResponseDto<>(HttpStatus.BAD_REQUEST.value(), "비밀번호 오류");
            }
        }
    }

    @GetMapping("/users/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "로그아웃 성공";
    }
}
