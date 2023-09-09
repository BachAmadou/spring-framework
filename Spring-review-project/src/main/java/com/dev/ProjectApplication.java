package com.dev;

import com.dev.config.EmployeeConfig;
import com.dev.service.SalaryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class ProjectApplication {

//    public static void main(String[] args) {
//
//        SpringApplication.run(ProjectApplication.class, args);
//
//        ApplicationContext container = new AnnotationConfigApplicationContext(EmployeeConfig.class);
//
//        SalaryService salaryService = container.getBean(SalaryService.class);
//
//        salaryService.calculateRegularSalary();
//    }

    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext(EmployeeConfig.class);
        SalaryService salaryService = container.getBean(SalaryService.class);

        salaryService.calculateRegularSalary();


    }

}
