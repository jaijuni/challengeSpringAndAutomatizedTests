package com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests.services;

import com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests.dtos.HouseDTO;
import com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests.dtos.RoomDTO;
import com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests.exceptions.NoAliasFoundedException;
import com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests.models.HouseModel;
import com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests.models.RoomModel;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public interface HouseService {
    Double getHouseSize(HouseDTO house);

    HouseDTO getHouseAmount(HouseDTO house) throws NoAliasFoundedException;

    RoomDTO getBiggestRoom(HouseDTO house);

    HashMap<String, Double> getTotalSizeByRoom(HouseDTO house);

    Double getValueByAliasName(String name) throws NoAliasFoundedException;
}
