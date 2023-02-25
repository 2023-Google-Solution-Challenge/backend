package com.example.signz.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class MemberDto {

    private String email;
    private String password;
    private Date birth;
    private String name;
    private String nickname;
    private String phone;
    private Double latitude;
    private Double longitude;
}
