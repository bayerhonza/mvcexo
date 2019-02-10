package com.ensimag.rie.mvcexo.model;

/**
 * Person class representing person entity.
 */
public class Person {

    private int id;
    private String name;
    private String surname;

    public Person() {}

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    /**
     * Getter of ID
     * @return id of person
     */
    public int getId() {
        return id;
    }

    /**
     * Setter of ID
     * @param id id of person
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter of name
     * @return name of person
     */
    public String getName() {
        return name;
    }

    /**
     * Setter of name
     * @param name name of person
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter of surname
     * @return surname of person
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Setter of surname
     * @param surname surname of person
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }
}
