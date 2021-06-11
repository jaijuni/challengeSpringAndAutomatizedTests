package com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests.dtos;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RoomDTO {
    @NotNull(message = "The name of room cannot be null")
    @Size(max = 30)
    private String name;

    @NotNull(message = "The width of room cannot be null")
    @Max(value = 25, message = "The maximum width of a room is 25 meters")
    private Double width;

    @NotNull(message = "The length of room cannot be null")
    @Max(value = 33, message = "The maximum length of a room is 33 meters")
    private Double length;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "RoomDTO{" +
                "name='" + name + '\'' +
                ", width=" + width +
                ", length=" + length +
                '}';
    }
}
