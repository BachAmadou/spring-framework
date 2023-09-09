package com.dev.service;

import com.dev.repository.EmployeeRepository;
import com.dev.repository.HourlyRepository;
import org.springframework.stereotype.Component;

@Component
public class SalaryService {

    EmployeeRepository employeeRepository;
    HourlyRepository hourlyRepository;

    public SalaryService(EmployeeRepository employeeRepository, HourlyRepository hourlyRepository) {
        this.employeeRepository = employeeRepository;
        this.hourlyRepository = hourlyRepository;
    }

    public void calculateRegularSalary() {
        // HourlyRate * Regular Hours
        System.out.println(employeeRepository.getHourlyRate() * hourlyRepository.getHours());

    }
}
