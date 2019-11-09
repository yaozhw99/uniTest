package com.example.demo.entity;


public class Dept {
    private int id;
    private int persons;
    private String deptName;


    public Dept(int id,int persons,String deptName ) {
        this.id=id;
        this.deptName = deptName;
        this.persons = persons;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPersons() {
        return persons;
    }

    public void setPersons(int persons) {
        this.persons = persons;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", persons=" + persons +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
