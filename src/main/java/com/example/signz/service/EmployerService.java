package com.example.signz.service;

import com.example.signz.entity.Employer;
import com.example.signz.repository.EmployerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployerService {

//    private final EmployerRepository employerRepository;

    @Autowired
    private EmployerRepository employerRepository;

    @Transactional
    public void insertEmployer(Employer employer) {
        employerRepository.save(employer);
    }

//    @Transactional(readOnly = true)
//    public Employer getEmployer(String bRegNum) {
//        // 검색 결과가 없을 때 빈 Employer 객체 반환
//        Employer findEmployer = employerRepository.findByBRegNum(bRegNum).orElseGet(
//                new Supplier<Employer>() {
//                    @Override
//                    public Employer get() {
//                        return new Employer();
//                    }
//                });
//        return findEmployer;
//    }
}
