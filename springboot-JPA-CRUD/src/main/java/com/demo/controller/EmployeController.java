package com.demo.controller;

import com.demo.constants.EndPointsConstant;
import com.demo.exception.RecordNotFoundException;
import com.demo.model.Employee;
import com.demo.repo.EmployeeRepo;
import com.demo.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeController {

    @Autowired
    EmployeeServiceImpl employeeServiceImpl;
    @Autowired
    private EmployeeRepo employeeRepo;

    @PostMapping(EndPointsConstant.SAVE_DATA)
    public ResponseEntity<Employee> saveData(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeServiceImpl.saveData(employee));
    }

    @GetMapping(EndPointsConstant.GET_ALL_DATA)
    public ResponseEntity<List<Employee>> getAllData() {
        return ResponseEntity.ok(employeeServiceImpl.getAllData());
    }

    @GetMapping(EndPointsConstant.GET_DATA_BY_ID)
    public ResponseEntity<Optional<Employee>> getDataById(@PathVariable int empId) {
        return ResponseEntity.ok(employeeServiceImpl.getDataById(empId));
    }

    @GetMapping(EndPointsConstant.GET_DATA_BY_DOB)
    public ResponseEntity<List<Employee>> getDataByDob(@PathVariable String empDOB) throws ParseException {
        return ResponseEntity.ok(employeeServiceImpl.getDataByEmpDob(empDOB));
    }

    @PutMapping(EndPointsConstant.UPDATE_DATA)
    public ResponseEntity<Employee> updateData(@PathVariable int empId, @RequestBody Employee employee) {

        Employee employee1 = employeeServiceImpl.getDataById(empId).orElseThrow(() -> new RecordNotFoundException("ID DOES NOT EXIT"));

        employee1.setEmpName(employee.getEmpName());
        employee1.setEmpSalary(employee.getEmpSalary());
        employee1.setEmpDOB(employee.getEmpDOB());
        return ResponseEntity.ok(employeeServiceImpl.updateData(employee1));
    }

    @DeleteMapping(EndPointsConstant.DELETE_BY_ID)
    public ResponseEntity<String> deleteDataById(@PathVariable int empId) {
        employeeServiceImpl.deleteDataById(empId);
        return ResponseEntity.ok("DATA DELETED");
    }
}
