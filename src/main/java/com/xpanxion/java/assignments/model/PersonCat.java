package com.xpanxion.java.assignments.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PersonCat {

    //
    // Data members
    //

    private int id;
    private String firstName;
    private List<Cat> catList;

    //
    // Constructors
    //

    public PersonCat() {
        this.catList = new ArrayList<>();
    }

    public PersonCat(int id, String firstName, List<Cat> catList) {
        this.id = id;
        this.firstName = firstName;
        this.catList = catList;
    }

    //
    // Accessors
    //

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public List<Cat> getCatList() {
        return catList;
    }

    public void setCatList(List<Cat> catList) {
        this.catList = catList;
    }

    //
    // Overrides
    //

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof PersonCat))
            return false;
        PersonCat personCat = (PersonCat) o;
        return getId() == personCat.getId() && getFirstName().equals(personCat.getFirstName())
                && getCatList().equals(personCat.getCatList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getCatList());
    }

    @Override
    public String toString() {
        return "PersonCat{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", catList=" + catList +
                '}';
    }
}
