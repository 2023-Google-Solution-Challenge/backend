package com.example.signz.controller;

import com.example.signz.entity.Member;
import com.example.signz.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/users")
@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/signup/employer")
    public @ResponseBody String insertEmployer(@RequestBody Member member) {
        memberService.saveEmployer(member);
        return member.getEmail() + " 고용주 회원가입 성공";
    }

    @PostMapping("/signup/employee")
    public @ResponseBody String insertEmployee(@RequestBody Member member) {
        memberService.saveEmployee(member);
        return member.getEmail() + " 근로자 회원가입 성공";
    }
}
