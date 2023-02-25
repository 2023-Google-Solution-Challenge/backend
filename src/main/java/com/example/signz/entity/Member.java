package com.example.signz.entity;

import com.example.signz.constant.RoleType;
import com.example.signz.dto.MemberDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "member")
@Getter
@Setter
@ToString
public class Member {

    @Id
    @Column(name="memberId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, unique = true, nullable = false)
    private String email;

    @Column(length = 12, nullable = false)
    private String password;

    @Column(nullable = false)
    private Date birth;

    @Column(length = 5, nullable = false)
    private String name;

    @Column(length = 30, nullable = false)
    private String nickname;

    @Column(length = 15, nullable = false)
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoleType roleType;

    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;

    public static Member createMember(MemberDto memberDto) {
        Member member = new Member();
        member.setEmail(memberDto.getEmail());
        member.setPassword(memberDto.getPassword());
        member.setBirth(memberDto.getBirth());
        member.setName(memberDto.getName());
        member.setNickname(memberDto.getNickname());
        member.setPhone(memberDto.getPhone());
        member.setLatitude(memberDto.getLatitude());
        member.setLongitude(member.getLongitude());
        return member;
    }
}
