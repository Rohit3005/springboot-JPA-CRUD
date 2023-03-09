package com.demo.repo;

import com.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

    //custom method

    public List<Employee> findByEmpDOB(Date empDOB);
}
