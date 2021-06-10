package com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests.models;

import com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests.dtos.HouseDTO;
import com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests.dtos.RoomDTO;

import java.util.List;

public class HouseModel {
    private String name;
    private String alias;
    private List<RoomModel> rooms;
    private Double amount;
    private Double totalSize;

    public HouseModel(String name, String alias, List<RoomModel> rooms) {
        this.name = name;
        this.alias = alias;
        this.rooms = rooms;
    }

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

    public List<RoomModel> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomModel> rooms) {
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

    public static RoomDTO getBiggestRoom(HouseDTO house) {
        RoomDTO biggestRoom = house.getRooms().get(0);

        for(RoomDTO room:house.getRooms()) {
            if(RoomModel.getSize(room) >= RoomModel.getSize(biggestRoom)) {
                biggestRoom = room;
            }
        }

        return biggestRoom;
    }

    @Override
    public String toString() {
        return "House{" +
                "name='" + name + '\'' +
                ", alias='" + alias + '\'' +
                ", rooms=" + rooms +
                ", amount=" + amount +
                ", totalSize=" + totalSize +
                '}';
    }
}
