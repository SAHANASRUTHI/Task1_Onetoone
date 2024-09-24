package com.kgisl.onetoone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kgisl.onetoone.entity.Otp;

public interface OtpRepository extends JpaRepository<Otp, Integer> {
}
