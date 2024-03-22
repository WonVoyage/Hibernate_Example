package org.example;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

public class CRUDUtils
{
    public static List<Student> getStudentData()
    {
        Query<Student> query;

        try(Session session = Main.getSession())
        {
            query = session.createQuery("from Student", Student.class);
            return query.list();
        }
    }

    public static List<Student> saveStudent(Student student)
    {
        Query<Student> query = null;
        Transaction transaction = null;

        try(Session session = Main.getSession())
        {
            transaction = session.beginTransaction();
            session.saveOrUpdate(student);
            transaction.commit();
            query = session.createQuery("from Student", Student.class);
            return query.list();
        }
        catch (Exception e)
        {
            if (transaction != null)
                transaction.rollback();

            e.printStackTrace();
        }

        return query.list();
    }

    public static List<Student> updateStudentName(Student student, String name)
    {
        Query<Student> query = null;
        Transaction transaction = null;

        try(Session session = Main.getSession())
        {
            transaction = session.beginTransaction();
            student.setName(name);
            session.saveOrUpdate(student);
            transaction.commit();
            //session.flush();
            query = session.createQuery("from Student", Student.class);
            return query.list();
        }
        catch (Exception e)
        {
            if (transaction != null)
                transaction.rollback();

            e.printStackTrace();
        }

        return query.list();
    }
}
