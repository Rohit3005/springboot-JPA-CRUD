package com.demo.dao;

import com.demo.model.Employee;
import com.demo.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class EmployeeDaoImpl {

    @Autowired
    EmployeeRepo employeeRepoImpl;

    public Employee saveData(Employee employee) {
        return employeeRepoImpl.save(employee);
    }

    public List<Employee> getAllData() {
        return employeeRepoImpl.findAll();
    }

    public Optional<Employee> getDataById(int empId) {
        return employeeRepoImpl.findById(empId);
    }

    public Employee updateData(Employee employee) {
        return employeeRepoImpl.save(employee);
    }

    public List<Employee> getDataByEmpDob(String empDOB) throws ParseException {
        List<Employee> employees = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date empDate = dateFormat.parse(empDOB);

        return employeeRepoImpl.findByEmpDOB(empDate);
    }

    public void deleteDataById(int empId) {
        employeeRepoImpl.deleteById(empId);
    }
}
