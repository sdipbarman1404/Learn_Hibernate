package org;

import jakarta.persistence.*;

@Entity
@Table (name = "Dev")
public class Developer {
    @Id

    private int id;
    @Column (name = "dev_name")
    private String name;

   // @Transient   // used to ignore the next column
    private String tech;
    private Laptop laptop;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop lapton) {
        this.laptop = lapton;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tech='" + tech + '\'' +
                ", laptop=" + laptop +
                '}';
    }
}

     
