package com.visjdbc.visjdbcprg.repository;

import com.visjdbc.visjdbcprg.model.Employee;

import java.util.List;

public interface EmployeeRepository {

    List<Employee> getList();

    String saveEmployee(Employee e);

    Employee getEmployeeById(Integer id);

    String updateEmployee(Employee e);

    String deleteEmployee(Integer id);
}
