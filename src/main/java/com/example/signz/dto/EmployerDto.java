package com.example.signz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerDto {

    private String bRegNum;
    private String bName;
    private String address;
    private Double latitude;
    private Double longitude;
    private String storeName;
    private String contact;
}
