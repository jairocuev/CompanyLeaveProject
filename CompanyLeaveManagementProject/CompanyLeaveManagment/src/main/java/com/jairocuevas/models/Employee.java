package com.jairocuevas.models;

public class Employee {
    long id;
    String name;
    boolean isAdmin;
    long accruedTime;
    int employeeType;
    int requestNumber;

    public Employee(long id, String name, long accruedTime ,boolean isAdmin, int employeeType) {
        this.id = id;
        this.name = name;
        this.accruedTime = accruedTime;
        this.isAdmin = isAdmin;
        this.employeeType = employeeType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public long getAccruedTime() {
        return accruedTime;
    }

    public void setAccruedTime(long accruedTime) {
        this.accruedTime = accruedTime;
    }

    public int getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(int employeeType) {
        this.employeeType = employeeType;
    }
    public void setRequestNumber(int number) {
    	this.requestNumber=number;
    }
    public int getRequestNumber() {
    	return requestNumber;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
