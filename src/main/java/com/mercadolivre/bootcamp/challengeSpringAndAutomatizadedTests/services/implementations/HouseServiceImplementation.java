package com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests.services.implementations;

import com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests.dtos.HouseDTO;
import com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests.dtos.RoomDTO;
import com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests.models.HouseModel;
import com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests.models.RoomModel;
import com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests.services.HouseService;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class HouseServiceImplementation implements HouseService {
    @Override
    public HouseDTO getHouseSize(HouseDTO house) {
        double totalSize = 0.0;

        for (RoomDTO room: house.getRooms()) {
            totalSize = totalSize + (RoomModel.getSize(room));
        }

        house.setTotalSize(totalSize);
        return house;
    }

    public HouseDTO getHouseAmount(HouseDTO house) {
        Double totalSize = this.getHouseSize(house).getTotalSize();
        house.setAmount(totalSize * 800);
        return house;
    }

    public RoomDTO getBiggestRoom(HouseDTO house) {
        return HouseModel.getBiggestRoom(house);
    }

    public HashMap<String, Double> getTotalSizeByRoom(HouseDTO house) {
        HashMap<String, Double> roomSizesHashMap = new HashMap<>();

        for (RoomDTO room: house.getRooms()) {
            roomSizesHashMap.put(room.getName(), RoomModel.getSize(room));
        }

        return roomSizesHashMap;
    }
}
