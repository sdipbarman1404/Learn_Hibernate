package org;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table (name = "Dev")
public class Developer {
    @Id

    private int id;
    @Column (name = "dev_name")
    private String name;

   // @Transient   // used to ignore the next column
    private String tech;


    //Below code is for One-to-One Relation
//    @OneToOne
//    private Laptop laptop;

     @OneToMany(mappedBy = "developer")

     private List<Laptop> laptop;

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

    public List<Laptop> getLaptop() {
        return laptop;
    }

    public void setLaptop(List<Laptop> laptop) {
        this.laptop = laptop;
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

     
