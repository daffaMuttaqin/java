package com.booking.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee extends Person {
    private int experience;

    @Override
    public String toString() {
        return "Employee ID: " + getId() +
            ", Name: " + getName() +
            ", Address: " + getAddress() +
            ", Experience: " + experience + " years";
    }
}