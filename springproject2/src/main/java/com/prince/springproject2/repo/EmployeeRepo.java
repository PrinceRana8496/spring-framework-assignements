package com.prince.springproject2.repo;

import com.prince.springproject2.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class EmployeeRepo {
    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }
    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Employee s)
    {
        String sql="insert into employee (id,name,designation) values (?,?,?)";
        int rows=jdbc.update(sql,s.getId(),s.getName(),s.getDesignation());
        System.out.println(rows+"effected");
    }

    public List<Employee> findAll() {
        String sql="select * from employee";
        RowMapper<Employee> mapper=(rs, rowNum)->{
                Employee s=new Employee();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setDesignation(rs.getString("designation"));
                return s;
            };
        return jdbc.query(sql,mapper);
    }
}
