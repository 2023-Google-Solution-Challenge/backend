package com.example.signz.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "employer")
@Getter
@Setter
@ToString
public class Employer {

    @Id
    @Column(name="employerId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 12, unique = true)
    private String bRegNum;

    @Column(length = 10, nullable = false)
    private String bName;

    @Column(length = 50, nullable = false)
    private String address;

    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;

    @Column(length = 20, nullable = false)
    private String storeName;

    @Column(length = 15, nullable = false)
    private String contact;

    @ManyToOne
    @JoinColumn(name = "memberId")
    private Member member;

//    public static Employer createWorkingSite(EmployerDto employerDto) {
//        Employer employer = new Employer();
//        employer.setAddress(employerDto.getAddress());
//        employer.setLatitude(employerDto.getLatitude());
//        employer.setLongitude(employerDto.getLongitude());
//        employer.setContact(employerDto.getContact());
//        employer.setBRegNum(employerDto.getBRegNum());
//        employer.setStoreName(employerDto.getStoreName());
//        employer.setBName(employerDto.getBName());
//        return employer;
//    }
}
