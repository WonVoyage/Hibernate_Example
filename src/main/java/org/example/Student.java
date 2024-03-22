package org.example;

import javax.persistence.*;


@Entity
@Table(name = "student")
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name_student;


    public Student(int id, String name_student)
    {
        this.id = id;
        this.name_student = name_student;
    }

    public Student()
    {

    }

    @Override
    public String toString()
    {
        return "Student" + "{" + "id = " + id + ", name_student = '" + name_student + '\'' + '}';
    }


    public String getName()
    {
        return name_student;
    }

    public void setName(String name_student)
    {
        this.name_student = name_student;
    }

}
