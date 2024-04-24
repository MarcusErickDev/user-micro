package com.siontech.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    private String brand;
    private String model;
    private int userId;

    public Car setUserId(int userId) {
        this.userId = userId;
        return this;
    }
}
