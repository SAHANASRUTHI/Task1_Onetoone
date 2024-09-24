package com.kgisl.onetoone.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Otp {

    @Id
    private int employeeId;
    private String otp;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

}
