package com.example.signz.controller;

import com.example.signz.dto.ResponseDto;
import com.example.signz.entity.Member;
import com.example.signz.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/users")
@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;
    // 1
//    @PostMapping("/signup/employer")
//    public @ResponseBody String insertEmployer(@RequestBody Member member) {
//        memberService.saveEmployer(member);
//        return member.getEmail() + " 고용주 회원가입 성공";
//    }
//
//    @PostMapping("/signup/employee")
//    public @ResponseBody String insertEmployee(@RequestBody Member member) {
//        memberService.saveEmployee(member);
//        return member.getEmail() + " 근로자 회원가입 성공";
//    }

    // 2
    @PostMapping("/signup/employer")
    public @ResponseBody ResponseDto<?> insertEmployer(@RequestBody Member member) {
        Member findMember = memberService.getMember(member.getEmail());

        if (findMember.getEmail() == null) {
            memberService.saveEmployer(member);
            return new ResponseDto<>(HttpStatus.OK.value(), member.getEmail() + "님 고용주 회원가입 성공");
        } else {
            return new ResponseDto<>(HttpStatus.BAD_REQUEST.value(), member.getEmail() + "님은 이미 회원입니다.");
        }
    }

    @PostMapping("/signup/employee")
    public @ResponseBody ResponseDto<?> insertEmployee(@RequestBody Member member) {
        Member findMember = memberService.getMember(member.getEmail());

        if (findMember.getEmail() == null) {
            memberService.saveEmployee(member);
            return new ResponseDto<>(HttpStatus.OK.value(), member.getEmail() + "님 근로자 회원가입 성공");
        } else {
            return new ResponseDto<>(HttpStatus.BAD_REQUEST.value(), member.getEmail() + "님은 이미 회원입니다.");
        }
    }
}
