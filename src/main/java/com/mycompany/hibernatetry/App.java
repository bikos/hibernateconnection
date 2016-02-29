package com.mycompany.hibernatetry;

import org.hibernate.Session;

public class App {

    public static void main(String[] args) {
        {
            System.out.println("Hello World!");

            Session session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Cds cds = new Cds("harke", "parshad", 911);

            session.save(cds);
            session.getTransaction().commit();

        }

    }

}
