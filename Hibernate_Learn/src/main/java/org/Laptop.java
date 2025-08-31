package org;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Laptop {
    @Id
    private int l_id;
    private String brand;
    private String model;
    private int ram;

    @ManyToMany(mappedBy = "laptop")
    private List <Developer> developer;

    public List<Developer> getDeveloper() {
        return developer;
    }

    public void setDeveloper(List<Developer> developer) {
        this.developer = developer;
    }

    public int getL_id() {
        return l_id;
    }

    public void setL_id(int l_id) {
        this.l_id = l_id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }


    @Override
    public String toString() {
        return "Laptop{" +
                "l_id=" + l_id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", ram=" + ram +
                '}';
    }
}