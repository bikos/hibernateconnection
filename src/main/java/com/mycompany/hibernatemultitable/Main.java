
package com.mycompany.hibernatemultitable;

import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {

    Session session = NewHibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    City city = new City("lolmandu", 23405);
    Position position = new Position("Director", 12000);
    Department department = new Department("Intelligence", "23rd strt");
    Employee employee = new Employee(city, department, position, "Harke", "Farke", 911922);
    session.save(city);
    session.save(position);
    session.save(department);
    session.save(employee);
    session.getTransaction().commit();
    session.close();
    
    }
    
}
