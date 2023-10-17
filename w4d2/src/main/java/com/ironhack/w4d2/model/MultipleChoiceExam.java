package com.ironhack.w4d2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class MultipleChoiceExam extends Exam {
    private Integer numberOfChoices;

    public MultipleChoiceExam() {
    }

    public Integer getNumberOfChoices() {
        return numberOfChoices;
    }

    public void setNumberOfChoices(Integer numberOfChoices) {
        this.numberOfChoices = numberOfChoices;
    }
}
