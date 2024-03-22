package org.example;

import org.hibernate.SessionFactory;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class Main
{
    static SessionFactory sessionFactory;

    static
    {
        try
        {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            sessionFactory = configuration.buildSessionFactory();
        }
        catch (Throwable ex)
        {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession()
    {
        return sessionFactory.openSession();
    }

    public static void main(String[] args)
    {
        System.out.println("Hello world!");
        List<Student> students = CRUDUtils.getStudentData();
        System.out.println(students);

        Student student = new Student();
        student.setName("Ivan");

        System.out.println(CRUDUtils.saveStudent(student));

        System.out.println(CRUDUtils.updateStudentName(student, "dadada"));
    }
}