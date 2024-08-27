package springExample.SpringMVCExample.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import springExample.SpringMVCExample.models.Student;

@Component
public class StudentDAO {
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
    public StudentDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
	
	public List<Student> index() {
        return jdbcTemplate.query("SELECT * FROM \"Students\"", new BeanPropertyRowMapper<>(Student.class));
    }

    public Student show(int id) {
        return jdbcTemplate.query("SELECT * FROM \"Students\" WHERE id=?", 
        							new Object[]{id}, 
        							new BeanPropertyRowMapper<>(Student.class))
                .stream().findAny().orElse(null);
    }

    public void save(Student student) {
        jdbcTemplate.update("INSERT INTO \"Students\"(name, age, registration_date) VALUES(?, ?, ?)", 
        					student.getName(), 
        					student.getAge(),
        					student.getRegistrationDate());
    }

    public void update(int id, Student student) {
        jdbcTemplate.update("UPDATE \"Students\" SET name=?, age=?, registration_date=? WHERE id=?", 
        					student.getName(),
        					student.getAge(), 
        					student.getRegistrationDate(), 
        					id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM \"Students\" WHERE id=?", id);
    }
}
