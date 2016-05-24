package com.mycompany.hibernatemultitable;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

public class CriteriaMain {

    public static void main(String[] args) {

        Session session = NewHibernateUtil.getSessionFactory().openSession();
        int currentyear = Calendar.getInstance().get(1);
        

        // creating the criteria query
        // Simple select with criteria
        try {

            Criteria criteria = session.createCriteria(Employee.class);
            List results = criteria.list();
            Iterator iterEmp = results.iterator();
            System.out.println("Year");
            System.out.println(currentyear);
            System.out.println("Printing criteria");
            while (iterEmp.hasNext()) {
                Employee empTemp = (Employee) iterEmp.next();
                System.out.println(empTemp.getEmpFname());

            }

        } catch (Exception e) {
            System.out.println("Cannot work with simple select on criteria" + e);
        } finally {
            session.flush();

        }

        // create criteria query with where condition
        try {
            Criteria criteria = session.createCriteria(Department.class, "Department");

            // FOR EXPRESSIONS, NEVER FORGET TO CAMEL CASE THE UNDERSCORE FROM THE DATABASE, SIMPLY CHECK 
            // VAR NAME ON THE SPECIFIC CLASS,  DATABASE HAS department_id, which is converted into departmentID in the class
            criteria.add(Restrictions.eq("departmentId", 6));
            List result = criteria.list();
            Iterator iterEmp = result.iterator();
            System.out.println("Printing criteria where condition");
            while (iterEmp.hasNext()) {
                Department empTemp = (Department) iterEmp.next();
                System.out.println(empTemp.getDepartmentName());

            }

        } catch (Exception e) {
            System.out.println("Cannot use criteria where condition " + e.getMessage());
        } finally {
            session.flush();
        }

        // criteria projection and transformation
        // transformation select the elements from existing pojo and maps it to another pojo[tranforms]
        // add.projections.property("var_name_from_old_pojo", "var_name_from_new_pojo")
        // setResultTransformer(Transformer.aliasToBean(New_pojo.class))
        // many times, the same pojo is transformed into new one, in that case var name remains same
        try {
            Criteria criteria = session.createCriteria(Employee.class, "Employee");

            criteria.setProjection(Projections.projectionList()
                    .add(Projections.property("empId"), "empId")
                    .add(Projections.property("city"), "city")
                    .add(Projections.property("position"), "position")
                    .add(Projections.property("empFname"), "empFname")
                    .add(Projections.property("empLastName"), "empLastName")
                    .add(Projections.property("empPhone"), "empPhone"))
                    .setResultTransformer(Transformers.aliasToBean(EmployeeTransform.class));

            criteria.setMaxResults(500);

            @SuppressWarnings("unchecked")
            List<EmployeeTransform> result = (List< EmployeeTransform>) criteria.list();
            Iterator temprator = result.iterator();
            while (temprator.hasNext()) {
                EmployeeTransform empTemp = (EmployeeTransform) temprator.next();
                System.out.println("Transformed Table values");
                System.out.println(empTemp.getEmpFname());
            }

        } catch (Exception e) {
            System.out.println("cannot project"+ e.getMessage());
        }
    }

}
