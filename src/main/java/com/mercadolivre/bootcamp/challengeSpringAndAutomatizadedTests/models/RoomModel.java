package com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests.models;

import com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests.dtos.RoomDTO;

public class RoomModel {
    private String name;
    private Double width;
    private Double length;

    public RoomModel(String name, Double width, Double height) {
        this.name = name;
        this.width = width;
        this.length = height;
    }

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

    public Double getHeight() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public static Double getSize(RoomDTO room) {
        return room.getLength() * room.getWidth();
    }

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", width=" + width +
                ", height=" + length +
                '}';
    }
}
