package com.dev.repository;

import com.dev.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class DBEmployeeRepository implements EmployeeRepository{
    //Assume we are getting this data from the db
    @Override
    public int getHourlyRate() {
        Employee employee = new Employee("Harold Finch","IT",65);

        return employee.getHourlyRate();
    }
}
