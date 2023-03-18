package com.example.signz.service;

import com.example.signz.constant.RoleType;
import com.example.signz.entity.Member;
import com.example.signz.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Supplier;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    @Autowired
//    private final MemberRepository memberRepository;
    private MemberRepository memberRepository;

    @Transactional
    public void saveEmployer(Member member) {
//        validateDuplicateMember(member);
        member.setRoleType(RoleType.EMPLOYER);
        memberRepository.save(member);
    }

    @Transactional
    public void saveEmployee(Member member) {
//        validateDuplicateMember(member);
        member.setRoleType(RoleType.EMPLOYEE);
        memberRepository.save(member);
    }
//
//    public void validateDuplicateMember(Member member) {
//        Member findMember = memberRepository.findByEmail(member.getEmail());
//        if (findMember != null) {
//            throw new IllegalStateException("이미 가입된 회원입니다.");
//        }
//    }

    @Transactional(readOnly = true)
    public Member getMember(String email) {
        // 검색 결과가 없을 때 빈 Member 객체 반환
        Member findMember = memberRepository.findByEmail(email).orElseGet(
                new Supplier<Member>() {
                    @Override
                    public Member get() {
                        return new Member();
                    }
                });
                return findMember;
    }
}
