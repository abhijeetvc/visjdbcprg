package com.visjdbc.visjdbcprg.dao;

import com.visjdbc.visjdbcprg.model.Employee;
import com.visjdbc.visjdbcprg.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDao implements EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Employee> getList() {
        String sql="select * from employee";
        List<Employee> list=jdbcTemplate.query(sql,
                new BeanPropertyRowMapper(Employee.class));
        return list;
    }

    @Override
    public String saveEmployee(Employee e) {
        String sql="insert into employee values(?,?,?)";
        jdbcTemplate.update(sql,new Object[]{e.getId(),e.getName(),e.getCity()});
        return "EMployee saved";
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        String sql="select * from employee where id=?";
        Employee e=jdbcTemplate.queryForObject(sql,new Object[]{id},
                new BeanPropertyRowMapper<>(Employee.class));
        return e;
    }

    @Override
    public String updateEmployee(Employee e) {
        String sql="update employee set name=?, city=? where id=?";
        int i=jdbcTemplate.update(sql,new Object[]{e.getName(),e.getCity(),e.getId()});
        if(i==0){
            return "Employee with given id does not exist";
        }
        return "Employee updated";
    }

    @Override
    public String deleteEmployee(Integer id) {
        String sql="delete from employee where id=?";
        int i=jdbcTemplate.update(sql,new Object[]{id});
        return "Employee deleted";
    }
}
