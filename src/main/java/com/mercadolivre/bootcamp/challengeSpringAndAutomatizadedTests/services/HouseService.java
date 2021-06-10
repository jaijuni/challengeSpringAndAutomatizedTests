package com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests.services;

import com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests.dtos.HouseDTO;
import com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests.dtos.RoomDTO;
import com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests.models.HouseModel;
import com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests.models.RoomModel;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public interface HouseService {
    HouseDTO getHouseSize(HouseDTO house);

    HouseDTO getHouseAmount(HouseDTO house);

    RoomDTO getBiggestRoom(HouseDTO house);

    HashMap<String, Double> getTotalSizeByRoom(HouseDTO house);
}
