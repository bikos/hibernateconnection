package com.mycompany.hibernatemultitable;


public class EmployeeTransform {

     private Integer empId;
     private City city;
     private Department department;
     private Position position;
     private String empFname;
     private String empLastName;
     private int empPhone;

    public EmployeeTransform() {
    }

    public EmployeeTransform(City city, Department department, Position position, String empFname, String empLastName, int empPhone) {
       this.city = city;
       this.department = department;
       this.position = position;
       this.empFname = empFname;
       this.empLastName = empLastName;
       this.empPhone = empPhone;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getEmpFname() {
        return empFname;
    }

    public void setEmpFname(String empFname) {
        this.empFname = empFname;
    }

    public String getEmpLastName() {
        return empLastName;
    }

    public void setEmpLastName(String empLastName) {
        this.empLastName = empLastName;
    }

    public int getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(int empPhone) {
        this.empPhone = empPhone;
    }
   


}


