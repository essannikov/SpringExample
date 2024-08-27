package springExample.SpringMVCExample.models;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class Student implements Comparable<Student>
{

    private Integer id;
    
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String name;
    
    @Min(value = 0, message = "Age should be greater than 0")
    private int age;
    
    //@NotEmpty(message = "Registration date should not be empty")
    @DateTimeFormat( pattern="yyyy-MM-dd")
    private Date registrationDate;
    
    public Student() {

    }
    
    public Student(int id, String name, int age, Date registrationDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.registrationDate = registrationDate;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public int compareTo(Student o) {
        return this.id.compareTo(o.getId());
    }
}