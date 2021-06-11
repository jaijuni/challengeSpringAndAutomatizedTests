package com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests.dtos;

import com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests.models.RoomModel;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class HouseDTO {

    @NotNull(message="The property name cannot be null")
    @Size(max=30, message = "The property name cannot have more of 30 characters")
    private String name;

    @NotNull(message = "The alias of property cannot be null")
    @Size(max=45, message = "The property alias cannot have more of 45 characters")
    private String alias;

    @Valid
    private List<RoomDTO> rooms;

    private Double amount;
    private Double totalSize;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public List<RoomDTO> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomDTO> rooms) {
        this.rooms = rooms;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Double totalSize) {
        this.totalSize = totalSize;
    }

    @Override
    public String toString() {
        return "HouseDTO{" +
                "name='" + name + '\'' +
                ", alias='" + alias + '\'' +
                ", rooms=" + rooms +
                ", amount=" + amount +
                ", totalSize=" + totalSize +
                '}';
    }
}
