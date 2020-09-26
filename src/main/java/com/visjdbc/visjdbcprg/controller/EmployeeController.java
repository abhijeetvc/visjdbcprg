package com.visjdbc.visjdbcprg.controller;

import com.visjdbc.visjdbcprg.dao.EmployeeDao;
import com.visjdbc.visjdbcprg.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping(value="/getemp")
    public List<Employee> getEmpList(){
        return employeeDao.getList();
    }

    @PostMapping(value="/save")
    public String saveEmp(@RequestBody Employee employee){
        return employeeDao.saveEmployee(employee);
    }

    @GetMapping(value="/getempbyid/{id}")
    public Employee getEmployee(@PathVariable Integer id){
        return employeeDao.getEmployeeById(id);
    }

    @PutMapping(value="/updateEmp")
    public String updateEmp(@RequestBody Employee e){
        return employeeDao.updateEmployee(e);
    }

    @DeleteMapping(value="/deleteEmp/{id}")
    public String deleteEmployee(@PathVariable Integer id){
        return employeeDao.deleteEmployee(id);
    }
}
