package org.example;

import org.example.models.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {

        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .buildSessionFactory()) {

            //Create session
            Session session = sessionFactory.getCurrentSession();

            //begin transaction
            session.beginTransaction();

            //Create object
            Course course = Course.create();
            Course course1 = Course.create();
            Course course2 = Course.create();
            session.save(course);
            System.out.println("Object course save successfully");
            session.save(course1);
            System.out.println("Object course1 save successfully");
            session.save(course2);
            System.out.println("Object course2 save successfully");

            //Read object
            Course retrievedCourse = session.get(Course.class, course.getId());
            System.out.println("Object course retrieved successfully");
            System.out.println("Retrieved course object: " + retrievedCourse);

            //Update object
            retrievedCourse.updateTitle();
            retrievedCourse.updateDuration();
            session.update(retrievedCourse);
            System.out.println("Object course update successfully");

            session.delete(retrievedCourse);
            System.out.println("Object course delete successfully");

            session.getTransaction().commit();

        } catch (Exception e){
            e.printStackTrace();
        }

    }

}
