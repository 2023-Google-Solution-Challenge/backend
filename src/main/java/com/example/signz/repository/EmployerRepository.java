package com.example.signz.repository;

import com.example.signz.entity.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

//@Primary
public interface EmployerRepository extends JpaRepository<Employer, Long> {
//    Optional<Employer> findByBRegNum(String bRegNum);
}
