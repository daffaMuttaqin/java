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
public class Customer extends Person {
    private double wallet;
    private Membership member;

    @Override
    public String toString() {
        return "Customer ID: " + getId() +
            ", Name: " + getName() +
            ", Address: " + getAddress() +
            ", Membership: " + member.getMembershipName() +
            ", Wallet: " + wallet;
    }
}
