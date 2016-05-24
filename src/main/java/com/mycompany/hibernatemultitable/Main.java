// java HQL operations
// 1. Insert
// 2. Update
// commit upon success
// roll back on failure on catch block
// close session on finally
package com.mycompany.hibernatemultitable;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class Main {

    public static void main(String[] args) {

        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        /* 
         //1 INSERT 
        
         //Method 1, create specific objects and pass objects as reference to the foreign keys
        
         // Following Block works
        
         City city = new City("pukhara", 23405);
         Position position = new Position("Guide", 12000);
         Department department = new Department("Tourism", "23rd strt");
         Employee employee = new Employee(city, department, position, "Hidua", "Kaila", 911922);
         session.save(city);
         session.save(position);
         session.save(department);
         session.save(employee);
         session.getTransaction().commit();
         session.close();
        
         */
        /*
        
         method 2, creating same object more than once is not feasible, we need to map to the objects already created
         We can use HQL query for that again, and write it
         building HQL queries
         Cannot insert the foreign key string or ID as the parameter, whole object
         has to be inserted ex employee(city_object, department_object, position_object, fname, lname, contact)
         Creating specific HQL queries to create city and position object
         
        
         This following block of code selects particular object from the database using HQL where condition, maps the
         result to the specific object type, using iterator over returned product, even if it iterating once with specific 
         city ID
         */
        try {
            String city_hql = "from City where emp_city_id=1";
            Query query1 = session.createQuery(city_hql);
            List results = query1.list();
            Iterator iter = results.iterator();
            //while (iter.hasNext()){
            City temp_city = (City) iter.next();
            System.out.println(temp_city.getCityName());

            // same for selecting position, department
            String position_hql = "from Position where position_id =2";
            Query query2 = session.createQuery(position_hql);
            List result2 = query2.list();
            Iterator iter2 = result2.iterator();
            Position temp_position = (Position) iter2.next();
            System.out.println(temp_position.getPositionName());

            String department_hql = "from Department where department_id = 4";
            Query query3 = session.createQuery(department_hql);
            List result3 = query3.list();
            Iterator iter3 = result3.iterator();
            Department temp_department = (Department) iter3.next();
            System.out.println(temp_department.getDepartmentName());

            Employee employee = new Employee(temp_city, temp_department, temp_position, "Bantawa", "Chemjong", 321231234);
            //session.save(employee);
            // commit for sucessful insertion

        } catch (Exception e) {
            System.out.println("Error in inserting" + e);
            //rollback if inserting fails
            session.getTransaction().rollback();
        }

        //2 updating the existing table, parameter
        try {

            String updateEmployeeHql = "UPDATE Employee set emp_fname=:fname"
                    + " where emp_id=:employee_id";
            Query query4 = session.createQuery(updateEmployeeHql);

            query4.setParameter("fname", "olamagio");
            query4.setParameter("employee_id", 9);
            int result = query4.executeUpdate();
            System.out.println("Rows affected: " + result);
            //use flush in a for loop
            //batch limit 20
        } catch (Exception e) {
            System.out.println("Error in updating" + e);

        }

        try {
            String department_hql = "from Employee where emp_id = 47";
            Query query5 = session.createQuery(department_hql);
            List result5 = query5.list();
            Iterator iter5 = result5.iterator();
            Employee temp_employee = (Employee) iter5.next();
            temp_employee.setEmpFname("Lohorke");
            System.out.println(temp_employee.getEmpFname());
            session.save(temp_employee);

        } catch (Exception e) {
            System.out.println("couldn't update employee method 2" + e);
            session.getTransaction().rollback();
        } finally {
            session.getTransaction().commit();
            session.close();
        }

    }

}
