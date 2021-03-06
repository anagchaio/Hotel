package com.utn;

import java.io.Serializable;
import java.util.Objects;

public abstract class Person implements Serializable {
    private static final long serialVersionUID = 7970889473436230100L;

    protected String name;
    protected String surname;
    protected String dni;
    protected Integer age;

    public Person(){

    }

    public Person(String name, String surname, String dni, Integer age) {
        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return  name + " " + surname + " DNI: " + dni + " Edad: " + age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(getDni(), person.getDni());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDni());
    }
}
