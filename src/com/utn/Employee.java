package com.utn;

import java.util.Objects;

public abstract class Employee extends Person {
    private static Integer counter = 1;
    protected Integer id;
    protected String userName;
    protected String password;

    public Employee(String name, String surname, String dni, Integer age, String userName, String password) {
        super(name, surname, dni, age);
        this.userName = userName;
        this.password = password;
        this.id = counter++;
    }

    public static void setCounter(Integer counter) {
        Employee.counter = counter;
    }

    public Integer getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    protected boolean login(String userName,String password){
        boolean flag = false;
        if(this.userName == userName && this.password == password){
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(getId(), employee.getId()) && Objects.equals(getUserName(), employee.getUserName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), getUserName());
    }
}
