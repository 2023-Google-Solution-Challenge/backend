package com.example.signz.service;

import com.example.signz.constant.RoleType;
import com.example.signz.entity.Member;
import com.example.signz.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member saveEmployer(Member member) {
        validateDuplicateMember(member);
        member.setRoleType(RoleType.EMPLOYER);
        return memberRepository.save(member);
    }

    public Member saveEmployee(Member member) {
        validateDuplicateMember(member);
        member.setRoleType(RoleType.EMPLOYEE);
        return memberRepository.save(member);
    }

    public void validateDuplicateMember(Member member) {
        Member findMember = memberRepository.findByEmail(member.getEmail());
        if (findMember != null) {
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }
}
