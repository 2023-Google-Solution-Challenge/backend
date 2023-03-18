package com.example.signz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
