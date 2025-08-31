package org;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity()

public class Students {
   @Id
    private int roll;
    private String name;
    private int score;

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Students{" +
                "roll=" + roll +
                ", name='" + name  +
                ", score=" + score +
                '}';
    }
}
