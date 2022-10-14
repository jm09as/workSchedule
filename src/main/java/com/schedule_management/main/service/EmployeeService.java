package com.schedule_management.main.service;

import com.schedule_management.main.model.Employee;
import com.schedule_management.main.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class EmployeeService {

    private EmployeeRepository employeeRepo;

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
    public void addEmployee(Employee employee) {
        employeeRepo.save(employee);
        log.info("Add employee to the database : %s".formatted(employee.toString()));
    }

    public List<Employee> getEmployees() {
        return employeeRepo.findAll();
    }

    public Employee getEmployee(Employee employee) {
        return employeeRepo.findById(employee.getId()).orElse(null);
    }

    public void deleteEmployById(Employee employee) {
        employeeRepo.deleteById(employee.getId());
    }

}
