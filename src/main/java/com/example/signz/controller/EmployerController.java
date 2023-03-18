package com.example.signz.controller;

import com.example.signz.dto.ResponseDto;
import com.example.signz.entity.Employer;
import com.example.signz.entity.Member;
import com.example.signz.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RequestMapping("/employer")
@RestController
public class EmployerController {

    @Autowired
    private EmployerService employerService;

    @PostMapping
    public @ResponseBody ResponseDto<?> insertEmployer(@RequestBody Employer employer, HttpSession session) {
        // Employer 객체를 영속화하기 전 연관된 Member 엔티티 설정
        Member principal = (Member) session.getAttribute("principal");
        employer.setMember(principal);
        System.out.println(employer.getBName());
        employerService.insertEmployer(employer);

        return new ResponseDto<>(HttpStatus.OK.value(), employer.getBRegNum() + " 사업장 등록 성공");
    }
}
