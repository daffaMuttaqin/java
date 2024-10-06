package com.booking.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Service {
    private String serviceId;
    private String serviceName;
    private double price;

    @Override
    public String toString() {
        return "Service ID: " + serviceId +
            ", Name: " + serviceName +
            ", Price: " + price;
    }
}
